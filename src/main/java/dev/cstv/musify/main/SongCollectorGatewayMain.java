package dev.cstv.musify.main;

import dev.cstv.musify.data.TestData;
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

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, SongCollectorGatewayMain.class);

        applicationContext.getBean(SongCollectorGatewayMain.class);

        applicationContext.getBean("testData", TestData.class).load();

        System.out.println("Loading songCollectorGateway...");

    }

}
