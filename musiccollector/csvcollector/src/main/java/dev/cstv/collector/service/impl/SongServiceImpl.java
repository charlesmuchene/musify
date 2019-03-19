package dev.cstv.collector.service.impl;

import org.apache.log4j.Logger;

import dev.cstv.collector.service.SongService;
import dev.cstv.musify.domain.Song;

public class SongServiceImpl implements SongService {

	private Logger LOG = Logger.getLogger(SongServiceImpl.class);
	
	public void create(Song song) {
		// TODO call webservice 
		System.out.println("calling REST: " + song.getTitle());
		
	}
	
}
