package dev.cstv.musify.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import dev.cstv.musify.domain.Artist;
import dev.cstv.musify.domain.Song;
import dev.cstv.musify.domain.SongOutput;
import dev.cstv.musify.service.ArtistService;
import dev.cstv.musify.service.SongService;

public class SongCollectorMessageListener implements MessageListener {

	@Autowired
	SongService songService;
	@Autowired
	ArtistService artistService;

	@Override
	public void onMessage(Message message) {
		System.out.println("Main App - Song Collector Listener - Message Received: ");
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			SongOutput songOutput = (SongOutput) objectMessage.getObject();
			System.out.println("     ReleaseDate: " + songOutput.getReleaseDate());

			Song song = new Song();
			song.setTitle(songOutput.getItem().getTitle());
			song.setUrl(songOutput.getItem().getUrl());
			song.setReleaseDate(songOutput.getReleaseDate());
			song.setDuration(1);
			//song.setArtist(getOrCreateArtist(song));

			songService.save(song);

		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private Artist getOrCreateArtist(Song song) {
		
		if (!CollectionUtils.isEmpty(artistService.findAll())) {
			return artistService.findAll().get(0);
		}
		Artist newArtist = new Artist(song.getTitle());
		artistService.save(newArtist);
		return artistService.findAll().get(0);
	}
}
