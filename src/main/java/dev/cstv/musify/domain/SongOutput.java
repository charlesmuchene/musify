package dev.cstv.musify.domain;

import java.io.Serializable;
import java.util.Date;
 
public class SongOutput  implements Serializable{

	private SongMessage item;
	
	private Date releaseDate;
    
    public SongOutput(SongMessage item) {
    	this.item = item;
		this.releaseDate = new Date();
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public SongMessage getItem() {
		return item;
	}

	public void setItem(SongMessage item) {
		this.item = item;
	}

}
