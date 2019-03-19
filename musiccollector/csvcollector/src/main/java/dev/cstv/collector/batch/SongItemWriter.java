package dev.cstv.collector.batch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import dev.cstv.collector.service.SongService;
import dev.cstv.musify.domain.Song;

/*
 * Declared in collector-job.xml
 */
public class SongItemWriter implements ItemWriter<Song>   {
	
	private Logger LOG = Logger.getLogger(SongItemWriter.class.getName());
	
	private SongService songService;

	public void write(List<? extends Song> songs) throws Exception {

		System.out.println("call songService ......SongItemWriter");
		
		for (Song song : songs) {
			songService.create(song);
		}
	}

	public SongService getSongService() {
		return songService;
	}

	public void setSongService(SongService songService) {
		this.songService = songService;
	}
	
}

