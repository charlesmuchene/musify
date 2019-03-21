package dev.cstv.musify.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SongCollectorListenerMain {

	private final static String[] configFilesGatewayDemo = {
			"/context/applicationContext.xml",
			 "/META-INF/spring/integration/common.xml",
			 "/META-INF/spring/integration/songCollectorGateway.xml",
			"/META-INF/spring/integration/jms-song-collector-app-context.xml" 
			 
	};

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

		System.out.println("\n========================================================="
				+ "\n                                                         "
				+ "\n               Song Listener                                "
				+ "\n                                                         "
				+ "\n=========================================================");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, SongCollectorListenerMain.class);

		applicationContext.getBean(SongCollectorListenerMain.class).mainInternal(applicationContext);
	}

	private void mainInternal(ApplicationContext applicationContext) {
		// Wait for Messages
	}

}
