package powerlogic.healthchecker;

import java.io.File;
import java.util.Date;
import java.util.Timer;

import org.codehaus.jackson.map.ObjectMapper;

import powerlogic.healthchecker.task.HealthCheckTask;

public class Main {

	public static Thread currentThread;
	
	public static void main(String [] args) throws Exception {

		currentThread = Thread.currentThread();
		ObjectMapper mapper = new ObjectMapper();
		Configuration configuration = mapper.readValue(new File("configuration.json"), Configuration.class);
		Timer timer;
		for(Application app : configuration.getApplications()){
	        timer = new Timer();
	        timer.schedule(new HealthCheckTask(app), new Date(), 60*1000);
		}
	}
}
