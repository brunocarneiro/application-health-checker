application-health-checker (AHC)
==========================

SIMPLE WEB APPLICATION AVAILABILITY MONITOR

HOW AHC WORKS? 

  Every minute the program sends a HTTP Header for the configured sites. If the site does not respond, AHC sends an email
  to the site administrator and then continue monitoring.

HOW DO I BUILD AHC?

  You must have Maven installed (http://maven.apache.org/)
  
  mvn clean compile assembly:assembly

HOW DO I CONFIGURE AHC?

  Create a file called 'configuration.json' in the same folder as the built jar. Edit it usin JSON syntax. EG.:

	{
		"emailConfig" : {
			"from": "myemail@mycompany.com.br",
			"user":"myemail@mycompany.com.br",
			"password":"mypass,
			"host":"smtp.mycompany.com.br",
			"port":null,
			"messageSubjectTemplate":"A aplicacao ${appName} está fora do ar.",
			"messageTemplate":"A aplicacao ${appName} está fora do ar. Verifique em ${appURL}"
		},
		

		"applications" : [
		
			{"name": "GIT", "url": "http://git.powerlogic.com.br:8080/gita", "emailAdmin":"bruno.carneiro@powerlogic.com.br"},
			{"name": "Archiva", "url": "http://update.powerlogic.com.br:8080/archiva/index.action", "emailAdmin":"bruno.carneiro@powerlogic.com.br"},
			{"name": "Nexus - BNDES", "url": "http://192.168.1.140:8081/nexus/index.html", "emailAdmin":"bruno.carneiro@powerlogic.com.br"},
			{"name": "Sonar - BNDES", "url": "http://192.168.1.140:9000/", "emailAdmin":"bruno.carneiro@powerlogic.com.br"},
			{"name": "Jenkins - BNDES", "url": "http://192.168.1.133:8080/jenkins", "emailAdmin":"bruno.carneiro@powerlogic.com.br"}
		
		]

	}


HOW DO I RUN AHC?

  java -jar application-health-checker-[VERSION]-jar-with-dependencies.jar
