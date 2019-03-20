package dev.cstv.musify.messaging.mail;

import java.util.ArrayList;
import java.util.List;

public class Mail {

    private String receipient;
    private String message;
    private Object attachment;
    private List<String> receipients = new ArrayList<>();

    public Mail() {

    }

    public Mail(List<String> receipients, String message) {
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


    public List<String> getReceipients() {
        return receipients;
    }

    public void addReceipient(String receipient) {
        this.receipients.add(receipient);
    }
}
