package dev.cstv.musify.security.rules;

import dev.cstv.musify.main.Main;
import dev.cstv.musify.security.AuthenticateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
 * 		evaluate hasPermission(#targetDomainObject, permission)
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    // Used in KLUDGE to get TIME ZONE from Console
    @Autowired
    AuthenticateUser authenticateUser;

    // hasPermission Method...
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

        // Time; device,geolocation  etc..."environment" rule attributes
        Map<String, Object> environment = new HashMap<>();
//        environment.put("timeZone" , authenticateUser.getTimeZone());

        // Look up asset specific policy/rules from "configured list"
        Policy policy = (Policy) Main.policyList.get(targetDomainObject.getClass().getSimpleName());
        // Policy is ABAC type context [ User,      action,            asset,            environment]
        return policy.checkRules(authentication, (String)permission, targetDomainObject, environment);
    }

    // hasPermission with target object TYPE instead of Object
    @Override
    public boolean hasPermission(Authentication authentication,
                                 Serializable targetId, String targetType, Object permission) {
        throw new UnsupportedOperationException();
    }
}
