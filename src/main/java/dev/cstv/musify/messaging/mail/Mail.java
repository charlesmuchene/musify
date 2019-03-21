package dev.cstv.musify.messaging.mail;

import java.io.Serializable;
import java.util.List;

public class Mail implements Serializable {

    private String receipientName;
    private String receipientEmail;
    private String chartTitle;
    private List<String> songs;

    public Mail() {
    }

    public Mail(String receipientName, String receipientEmail, String chartTitle, List<String> songs) {
        this.receipientName = receipientName;
        this.receipientEmail = receipientEmail;
        this.chartTitle = chartTitle;
        this.songs = songs;
    }

    public String getReceipientName() {
        return receipientName;
    }

    public void setReceipientName(String receipientName) {
        this.receipientName = receipientName;
    }

    public String getReceipientEmail() {
        return receipientEmail;
    }

    public void setReceipientEmail(String receipientEmail) {
        this.receipientEmail = receipientEmail;
    }

    public String getChartTitle() {
        return chartTitle;
    }

    public void setChartTitle(String chartTitle) {
        this.chartTitle = chartTitle;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
}

