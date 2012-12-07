application-health-checker (AHC)
==========================

SIMPLE WEB APPLICATION AVAILABILITY MONITOR

HOW AHC WORKS? 

  Each minute the program sends a HTTP Header for the configured sites. If the site does not respond, AHC sends an email
  to the site administrator and then continues monitoring.

HOW DO I BUILD AHC?

  You must have Maven installed (http://maven.apache.org/)
  
  mvn clean compile assembly:assembly

HOW DO I CONFIGURE AHC?

  Create a file called 'configuration.json' in the same folder as the built jar. Edit it usin JSON syntax. EG.:

  {
  
    "applications" : [
  	
  		{"nome": "GIT", "endereco": "http://git.powerlogic.com.br", "emailAdmin":"bruno.carneiro@powerlogic.com.br"},
  		{"nome": "Archiva", "endereco": "http://archiva.powerlogic.com.br:", "emailAdmin":"bruno.carneiro@powerlogic.com.br"},
  		{"nome": "Nexus - BNDES", "endereco": "http://192.168.1.140:8081/nexus/index.html", "emailAdmin":"bruno.carneiro@powerlogic.com.br"},
  		{"nome": "Sonar - BNDES", "endereco": "http://192.168.1.140:9000/", "emailAdmin":"bruno.carneiro@powerlogic.com.br"},
  		{"nome": "Jenkins - BNDES", "endereco": "http://192.168.1.133:8080/jenkins", "emailAdmin":"bruno.carneiro@powerlogic.com.br"}
  	]
  
  }


HOW DO I RUN AHC?

  java -jar application-health-checker-[VERSION]-jar-with-dependencies.jar