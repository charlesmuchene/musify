package dev.cstv.musify.amqp;

import dev.cstv.musify.domain.SongMessage;
import dev.cstv.musify.domain.SongOutput;

public interface SongTransformer {

	SongOutput transform (SongMessage item);
}
