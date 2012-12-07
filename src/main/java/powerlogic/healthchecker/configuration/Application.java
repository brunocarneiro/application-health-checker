package powerlogic.healthchecker.configuration;

public class Application {

	private String name;
	private String url;
	private String  emailAdmin;
	private Long lastTimeEmailSent;
	
	public Long getLastTimeEmailSent() {
		return lastTimeEmailSent;
	}
	public void setLastTimeEmailSent(Long lastTimeEmailSent) {
		this.lastTimeEmailSent = lastTimeEmailSent;
	}
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String endereco) {
		this.url = endereco;
	}
	public String getEmailAdmin() {
		return emailAdmin;
	}
	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}
	
	
	
}
