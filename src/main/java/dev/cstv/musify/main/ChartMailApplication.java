package dev.cstv.musify.main;

import dev.cstv.musify.data.TestData;
import dev.cstv.musify.domain.Chart;
import dev.cstv.musify.domain.User;
import dev.cstv.musify.messaging.mail.MailTask;
import dev.cstv.musify.service.ChartService;
import dev.cstv.musify.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ChartMailApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        TestData testData = ctx.getBean("testData", TestData.class);
        testData.load();

        MailTask mailTask = (MailTask) ctx.getBean("mailTaskImpl");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        ChartService chartService = (ChartService) ctx.getBean("chartServiceImpl");

        mailTask.setRoutingKey("chart.mail");

        Chart chart = chartService.findOne(1);
        List<User> users = new ArrayList<>();
        users.add(userService.findOne(1));
        users.add(userService.findOne(2));
        users.add(userService.findOne(3));

        users.forEach(user ->
            mailTask.sendMail(user, chart)
        );

        System.out.println("*** Send mail object to mailQueue ***");

    }
}
