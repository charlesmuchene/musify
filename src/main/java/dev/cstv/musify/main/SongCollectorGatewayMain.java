package dev.cstv.musify.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SongCollectorGatewayMain {

	private final static String[] configFilesGatewayDemo = {"/context/applicationContext.xml",
			"/META-INF/spring/integration/common.xml",
			"/META-INF/spring/integration/songCollectorGateway.xml" 
			};

	public static void main(String[] args) {

		System.out.println("    Loading songCollectorGateway...");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, SongCollectorGatewayMain.class);

		applicationContext.getBean(SongCollectorGatewayMain.class).mainInternal(applicationContext);
	}

	private void mainInternal(ApplicationContext applicationContext) {
		// Wait for Messages
	}

}
