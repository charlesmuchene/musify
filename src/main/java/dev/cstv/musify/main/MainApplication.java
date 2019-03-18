package dev.cstv.musify.main;

import dev.cstv.musify.resources.PlayResource;
import dev.cstv.musify.resources.SongResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

/**
 * Main Jersey Application
 */
public class MainApplication extends ResourceConfig {

    public MainApplication() {
        register(RequestContextFilter.class);
        register(SongResource.class);
        register(PlayResource.class);
    }
}