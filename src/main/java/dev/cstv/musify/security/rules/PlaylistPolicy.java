package dev.cstv.musify.security.rules;

import dev.cstv.musify.domain.Playlist;
import dev.cstv.musify.domain.User;
import dev.cstv.musify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.Map;

public class PlaylistPolicy implements Policy {
    @Autowired
	PlaylistService playlistService;

    private Playlist playlist;

    public PlaylistPolicy() {}

    // Evaluate Rules
	public Boolean checkRules(Authentication authentication, String action, Object asset, Map environment) {
		// Call default interface method
		if (!hasActionAuthority(action)) return false;

		this.playlist = (Playlist)asset;
//		this.timeZone = (String) environment.get("timeZone");

		Boolean result = false;
		Boolean owner = false;

		// Check for ownership of resource [domainObject]
 		String userName = this.getUser().getUserCredentials().getUsername();
    	if (authentication.getName().equals(userName))
    		owner = true;

    	// perform actions based on permission

    	switch (action) {

	    	case "update":

 	    		// We can execute "Generic" rules here
	    		if (!owner) {
	     	    	System.out.println("VIOLATED Update Owner RULE!!");
	     	    	result =  false;
	    		}

	    		// Only allow updates if in Central Time Zone
//	    		else if (!TimeZone.getDefault().getDisplayName().equals(timeZone)) {
//
//	    			System.out.println("VIOLATED Playlist Update Time Zone RULE!!");
//	     	    	result =  false;
//	     	    }
	    		else {

	    			System.out.println("Rules EVALUATION related to Playlist update request SUCCESSFULL");
	    			result =  true;
	    		}

	    		break;

	    	case "delete":
	    		System.out.println("EVALUATING Rules related to Playlist delete request...");
 	    		result = true;
 	    		break;

	    	case "save":
	    		System.out.println("EVALUATING Rules related to Playlist save request...");
	    		result = true;
    	}

 		return result;
	}

    public User getUser() {
        return playlist.getUser();
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
