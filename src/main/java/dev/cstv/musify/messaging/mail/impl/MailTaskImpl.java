package dev.cstv.musify.messaging.mail.impl;

import dev.cstv.musify.aop.Log;
import dev.cstv.musify.domain.Chart;
import dev.cstv.musify.domain.User;
import dev.cstv.musify.messaging.mail.Mail;
import dev.cstv.musify.messaging.mail.MailTask;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MailTaskImpl implements MailTask {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void setRoutingKey(String routingKey) {

        rabbitTemplate.setRoutingKey(routingKey);
    }

    @Log(message = "Mail Task has been sent to mail Server")
    @Override
    public void sendMail(User user, String message, Chart chart) {

//        Mail mail = new Mail(user.getUserCredentials().getEmail(), message);
//        mail.setAttachment(attachment);

        HashMap<String, String> recipient = new HashMap<>();

        recipient.put(user.getUserCredentials().getEmail(), user.getFirstName());

//        JSONObject mail = new JSONObject();
//        mail.put("message", message);
//        mail.put("recipients", recipient);
//        mail.put("attachment", attachment);

        List<String> songs=chart.getSongs().stream().map(chartSong -> chartSong.getSong().getTitle()).collect(Collectors.toList());

        Mail mail = new Mail(user.getFirstName(),user.getUserCredentials().getEmail(),chart.getName(),songs);

        rabbitTemplate.convertAndSend(mail);
    }

    @Log(message = "Mail Tasks have been sent to mail Server")
    @Override
    public void sendMails(List<User> users, String message, Object attachment) {
    }
}
