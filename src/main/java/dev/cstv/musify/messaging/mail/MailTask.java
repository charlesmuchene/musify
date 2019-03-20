package dev.cstv.musify.messaging.mail;

import dev.cstv.musify.domain.User;

import java.util.List;

public interface MailTask {

    void sendMail(User user,String Message,Object attachment);

    void sendMails(List<User> users,String Message,Object attachment);

    void setRoutingKey(String key);

}
