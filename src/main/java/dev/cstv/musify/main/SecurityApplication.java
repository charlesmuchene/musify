package dev.cstv.musify.main;

import dev.cstv.musify.data.TestData;
import dev.cstv.musify.domain.Playlist;
import dev.cstv.musify.domain.User;
import dev.cstv.musify.domain.UserCredentials;
import dev.cstv.musify.security.AuthenticateUser;
import dev.cstv.musify.security.rules.PlaylistPolicy;
import dev.cstv.musify.service.PlaylistService;
import dev.cstv.musify.service.UserCredentialsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashMap;
import java.util.Map;

public class SecurityApplication {

    public static Map<String, Object> policyList = new HashMap<String, Object>();

    public static void main(String[] args) {
        System.out.println("Musify");
        System.out.println("Bring Music to the World");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        TestData testData = ctx.getBean("testData",TestData.class);
        testData.load();

        AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");

        PlaylistService playlistService = (PlaylistService)ctx.getBean("playlistServiceImpl");
        UserCredentialsService userCredentialsService = (UserCredentialsService) ctx.getBean("userCredentialsServiceImpl");
        AuthenticateUser authenticateUser = (AuthenticateUser) ctx.getBean("authenticateUser");

        // "Configured list of policies/rules
        policyList.put("Playlist", new PlaylistPolicy());

        System.out.println("\n!!! Please login, Use `john` for username and password to create one playlist for this user !!!");
        try {
            authenticateUser.authenticate(authenticationManager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String userName =  SecurityContextHolder.getContext().getAuthentication().getName();
        UserCredentials johnUserCredentials = userCredentialsService.findByUserName(userName);
        User johnUser = johnUserCredentials.getUser();

        Playlist playlist = new Playlist("Have a Great Day!", johnUser);
        playlistService.save(playlist);
        System.out.println("*** Create playlist for user: " + johnUser.getFirstName());

        authenticateUser.logout();
        System.out.println("*** Logged out");

        System.out.println("\n!!! Please login, Use `paul` for username and password, Try to update a playlist that belongs to another user !!!");

        //noinspection InfiniteLoopStatement
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
                System.out.println("\n!!! Please login again to update a playlist that belongs to john, Use `john` for username and password !!!");
            }
        }

    }
}
