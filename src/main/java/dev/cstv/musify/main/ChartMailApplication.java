package dev.cstv.musify.main;

import dev.cstv.musify.data.TestData;
import dev.cstv.musify.messaging.mail.MailTask;
import dev.cstv.musify.service.ChartService;
import dev.cstv.musify.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChartMailApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        TestData testData = ctx.getBean("testData", TestData.class);
        testData.load();

        MailTask mailTask = (MailTask) ctx.getBean("mailTaskImpl");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        ChartService chartService = (ChartService) ctx.getBean("chartServiceImpl");

        mailTask.setRoutingKey("chart.mail");

        mailTask.sendMail(userService.findOne(1), null, chartService.findOne(1));

        System.out.println("*** Send mail object to mailQueue ***");

    }
}
