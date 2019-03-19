package dev.cstv.musify.security.rules;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/*
 * executes the rules in an ABAC type context [ User,action, asset,environment]
 */
		
public interface Policy {

 	public Boolean checkRules(Authentication authentication, String action, Object asset, Map envronment);
 	
 	// Check for permission 
 	public default Boolean hasActionAuthority(String action) {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
 		if (!authorities.contains(new SimpleGrantedAuthority(action)) ) 
 			return false;
 		return true;
 	}
 	
  }
