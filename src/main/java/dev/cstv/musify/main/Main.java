package dev.cstv.musify.main;

import dev.cstv.musify.domain.*;
import dev.cstv.musify.security.AuthenticateUser;
import dev.cstv.musify.security.rules.PlaylistPolicy;
import dev.cstv.musify.service.GroupService;
import dev.cstv.musify.service.PlaylistService;
import dev.cstv.musify.service.UserCredentialsService;
import dev.cstv.musify.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.AccessDeniedException;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, Object> policyList = new HashMap<String, Object>();

    public static void main(String[] args) {
        System.out.println("Play and Work");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

        AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");

        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        GroupService groupService = (GroupService) ctx.getBean("groupServiceImpl");
        PlaylistService playlistService = (PlaylistService)ctx.getBean("playlistServiceImpl");
        UserCredentialsService userCredentialsService = (UserCredentialsService) ctx.getBean("userCredentialsServiceImpl");
        AuthenticateUser authenticateUser = (AuthenticateUser) ctx.getBean("authenticateUser");

        // "Configured list of policies/rules
        policyList.put("Playlist", new PlaylistPolicy());

        Group groupUser = new Group();
        groupUser.setName("User");

        Authority authority = new Authority();
        authority.setAuthority("create");
        groupUser.getAuthority().add(authority);

        authority = new Authority();
        authority.setAuthority("update");
        groupUser.getAuthority().add(authority);

        authority = new Authority();
        authority.setAuthority("delete");
        groupUser.getAuthority().add(authority);

        authority = new Authority();
        authority.setAuthority("list");
        groupUser.getAuthority().add(authority);

        UserCredentials johnUserCredentials = new UserCredentials("john", "john", "john@musify.com");
        User johnUser = new User("John", "Smith", johnUserCredentials);
        userService.saveFull(johnUser);

        UserCredentials paulUserCredentials = new UserCredentials("paul", "paul", "paul@musify.com");
        User paulUser = new User("Paul", "Smith", paulUserCredentials);
        userService.saveFull(paulUser);

        groupUser.getUserCredentials().add(johnUserCredentials);
        groupUser.getUserCredentials().add(paulUserCredentials);
        groupService.save(groupUser);

        try {
            authenticateUser.authenticate(authenticationManager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String userName =  SecurityContextHolder.getContext().getAuthentication().getName();
        johnUserCredentials = userCredentialsService.findByUserName(userName);
        johnUser = johnUserCredentials.getUser();

        Playlist playlist = new Playlist("Have a Great Day!", johnUser);
        playlistService.save(playlist);

        authenticateUser.logout();

        while (true) {
            try {
                authenticateUser.authenticate(authenticationManager);
            } catch(Exception e) {
                e.printStackTrace();
            }

            try {
                playlist.setName("Happy Day");
                playlistService.update(playlist);
                System.out.println("****** ACCESS ALLOWED ! You ARE OWNER - you CAN  Update  **********");

            } catch ( AccessDeniedException e) {
                System.out.println("****** ACCESS DENIED ! You Need to be OWNER to Update  **********");
            }
        }
    }
}