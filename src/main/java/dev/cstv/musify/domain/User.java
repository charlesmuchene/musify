package dev.cstv.musify.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "{NotNull}")
    @Pattern(regexp = "^[A-Za-z]+", message = "{Pattern}")
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @NotNull(message = "{NotNull}")
    @Pattern(regexp = "^[A-Za-z]+", message = "{Pattern}")
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @NotNull
    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "user", referencedColumnName = "id")
    private UserCredentials userCredentials;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    @Fetch(FetchMode.SUBSELECT)
    private List<Playlist> playlists = new ArrayList<Playlist>();

    public User() {
    }

    public User(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, UserCredentials userCredentials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userCredentials = userCredentials;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }
}

