package dev.cstv.musify.main;

import dev.cstv.musify.resources.PlayResource;
import dev.cstv.musify.resources.SongResource;
import dev.cstv.musify.security.CORSResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class JerseyApp extends ResourceConfig {
    public JerseyApp() {
        register(RequestContextFilter.class);
        register(PlayResource.class);
        register(SongResource.class);
        register(CORSResponseFilter.class);
    }
}
