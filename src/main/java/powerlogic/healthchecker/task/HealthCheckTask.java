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

import powerlogic.healthchecker.Application;

public class HealthCheckTask extends TimerTask {

	private Application app;

	public HealthCheckTask(Application app) {
		this.app = app;
	}

	@Override
	public void run() {
		HttpClient httpClient = new HttpClient();
		HeadMethod head = new HeadMethod(app.getEndereco());
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

	private void sendAdminEmail() {
		//se mandou algum email até 10hs atras
		if(app.getLastTimeEmailSent()==null || (new Date().getTime()-app.getLastTimeEmailSent())/(1000*60*60)>10){
			
			String to = app.getEmailAdmin();
			
			String from = "hudson@powerlogic.com.br";
			
			String host = "smtp.powerlogic.com.br";
			
			Properties properties = System.getProperties();
			
			properties.setProperty("mail.user", "hudson@powerlogic.com.br");
			properties.setProperty("mail.password", "P0w3rl0g1c");
			
			properties.setProperty("mail.smtp.host", host);
			
			Session session = Session.getDefaultInstance(properties);
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to));
				
				message.setSubject("Aplicação " + app.getNome()
						+ " está fora do ar.");
				
				message.setText("Aplicação " + app.getNome()
						+ " está fora do ar. Verifique em: " + app.getEndereco());
				
				// Send message
				Transport.send(message);
				System.out.println("Sent message successfully....");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		}

	}

}
