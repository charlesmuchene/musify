package dev.cstv.musify.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private UserCredentials userCredentials;

    @Transient
    private List<Playlist> playlists = new ArrayList<Playlist>();

    public User() {
    }

    public User(String firstName, String lastName, UserCredentials userCredentials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userCredentials = userCredentials;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

