package dev.cstv.musify.messaging.mail;

import dev.cstv.musify.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mail {

    private Object attachment;
    private String receipient;
    private String receipientName;
    private String receipientEmail;
    private String message;
    private String chartTitle;
    private List<String> songs;

    private HashMap<String, String> receipients = new HashMap<>();

    public Mail() {

    }

    public Mail(String receipientName, String receipientEmail, String chartTitle, List<String> songs) {
        this.receipientName = receipientName;
        this.receipientEmail = receipientEmail;
        this.chartTitle = chartTitle;
        this.songs = songs;
    }

    public Mail(HashMap<String,String> receipients, String message) {
        this.receipients = receipients;
        this.message = message;
    }

    public Mail(String receipient, String message) {
        this.receipient = receipient;
        this.message = message;
    }

    public Mail(String receipient, String message, Object attachment) {
        this.receipient = receipient;
        this.message = message;
        this.attachment = attachment;
    }

    public String getReceipient() {
        return receipient;
    }

    public void setReceipient(String receipient) {
        this.receipient = receipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getAttachment() {
        return attachment;
    }

    public void setAttachment(Object attachment) {
        this.attachment = attachment;
    }

    public HashMap<String,String> getReceipients() {
        return receipients;
    }

    public void addReceipient(String receipient,String name) {

        this.receipients.put(receipient,name);
    }
}
