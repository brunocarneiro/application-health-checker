package powerlogic.healthchecker.task;

import java.util.Date;
import java.util.Properties;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.HeadMethod;

import powerlogic.healthchecker.Main;
import powerlogic.healthchecker.configuration.Application;
import powerlogic.healthchecker.configuration.Configuration;

public class HealthCheckTask extends TimerTask {

	private Application app;
	private Configuration config;

	public HealthCheckTask(Application app, Configuration config) {
		this.app = app;
		this.config = config;
	}

	@Override
	public void run() {
		joinMainThread();
		HttpClient httpClient = new HttpClient();
		HeadMethod head = new HeadMethod(app.getUrl());
		head.setFollowRedirects(true);
		int resultCode = 0;
		try {
			resultCode = httpClient.executeMethod(head);
		} catch (Exception e) {
			sendAdminEmail();
		}
		if (resultCode != 200) {
			sendAdminEmail();
			app.setLastTimeEmailSent(new Date().getTime());
		}

	}

	protected void joinMainThread() {
		try{
			Main.currentThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void sendAdminEmail() {
		//se mandou algum email até 10hs atras
		if(app.getLastTimeEmailSent()==null || (new Date().getTime()-app.getLastTimeEmailSent())/(1000*60*60)>10){
			
			String to = app.getEmailAdmin();
			
			String from = config.getEmailConfig().getFrom();
			
			String host = config.getEmailConfig().getHost();
			
			Properties properties = System.getProperties();
			
			properties.setProperty("mail.user", config.getEmailConfig().getUser());
			properties.setProperty("mail.password", config.getEmailConfig().getPassword());
			
			properties.setProperty("mail.smtp.host", host);
			
			Session session = Session.getDefaultInstance(properties);
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to));
				
				String subject = translateMsgTemplate(config.getEmailConfig().getMessageSubjectTemplate());
				
				String text = translateMsgTemplate(config.getEmailConfig().getMessageTemplate());
				
				message.setSubject(subject);
				
				message.setText(text);
				
				// Send message
				Transport.send(message);
				System.out.println("Sent message successfully....");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		}

	}

	protected String translateMsgTemplate(String template) {
		return template.replace("${appName}", app.getName()).replace("${appURL}", app.getUrl());
	}

}
