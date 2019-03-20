package dev.cstv.musify.messaging.mail;

import dev.cstv.musify.domain.User;

import java.util.List;

public interface MailTask {

    void sendMail(User user,String Message);

    void sendMails(List<User> users,String Message);

    void setRoutingKey(String key);

}
