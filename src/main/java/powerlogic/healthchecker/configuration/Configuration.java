package powerlogic.healthchecker.configuration;

public class Configuration {

	private EmailConfiguration emailConfig;
	private Application[] applications;

	
	public Application[] getApplications() {
		return applications;
	}

	public void setApplications(Application[] applications) {
		this.applications = applications;
	}

	public EmailConfiguration getEmailConfig() {
		return emailConfig;
	}

	public void setEmailConfig(EmailConfiguration emailConfig) {
		this.emailConfig = emailConfig;
	}

	
}
