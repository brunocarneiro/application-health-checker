package powerlogic.healthchecker.configuration;

public class EmailConfiguration {
	
	private String from;
	private String user;
	private String password;
	private String host;
	private String port;
	private String messageTemplate;
	private String messageSubjectTemplate;
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getMessageTemplate() {
		return messageTemplate;
	}
	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = messageTemplate;
	}
	public String getMessageSubjectTemplate() {
		return messageSubjectTemplate;
	}
	public void setMessageSubjectTemplate(String messageSubjectTemplate) {
		this.messageSubjectTemplate = messageSubjectTemplate;
	}
	
	
}
