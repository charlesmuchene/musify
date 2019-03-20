package dev.cstv.musify.amqp;

import java.util.Date;

import org.springframework.integration.annotation.Transformer;

import dev.cstv.musify.domain.Song;
import dev.cstv.musify.domain.SongMessage;
import dev.cstv.musify.domain.SongOutput;

public class SongTransformerImpl implements SongTransformer {

	/**
     * Transform data
     */
	@Transformer(inputChannel="fromAmqpSongCollectorChannel", outputChannel="processSong")
	public SongOutput transform(SongMessage item) {
		SongOutput output = new SongOutput(item);
		// call REST to map data
		System.out.println("SongTransformerImpl call REST to map data ----");
		System.out.println(item.getTitle() + " " + item.getUrl());
		
		return output;
	}

}
