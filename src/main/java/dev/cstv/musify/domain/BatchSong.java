package dev.cstv.musify.domain;

import java.io.Serializable;
import java.util.Date;

public class BatchSong implements Serializable{

    private static final long serialVersionUID = 6529685098267757690L;

    private String title;
    
    private String url;
 
    private Integer duration;
    
    private String year;

    private Date releaseDate;

    public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
 
 
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
