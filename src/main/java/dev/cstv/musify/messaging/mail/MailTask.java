package dev.cstv.musify.messaging.mail;

import dev.cstv.musify.domain.Chart;
import dev.cstv.musify.domain.User;

import java.util.List;

public interface MailTask {

    void sendMail(User user, Chart chart);

    void setRoutingKey(String key);

}
