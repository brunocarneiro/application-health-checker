package powerlogic.healthchecker;

public class Application {

	private String nome;
	private String endereco;
	private String  emailAdmin;
	private Long lastTimeEmailSent;
	
	public Long getLastTimeEmailSent() {
		return lastTimeEmailSent;
	}
	public void setLastTimeEmailSent(Long lastTimeEmailSent) {
		this.lastTimeEmailSent = lastTimeEmailSent;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmailAdmin() {
		return emailAdmin;
	}
	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}
	
	
	
}
