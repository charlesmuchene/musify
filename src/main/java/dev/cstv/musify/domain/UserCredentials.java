package dev.cstv.musify.domain;

import javax.persistence.*;

@Entity
@Table(name = "Credentials")
public class UserCredentials {

    @Id
    @Column(name = "username", nullable = false, unique = true, length = 127)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    @Column(name = "verifyPassword")
    private String verifyPassword;

    @OneToOne(mappedBy="userCredentials", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;

    public UserCredentials() {
    }

    public UserCredentials(User user, String username, String password, String email, String verifyPassword) {
        this.user = user;
        this.username = username;
        this.password = password;
        this.email = email;
        this.verifyPassword = verifyPassword;
    }

    public UserCredentials(User user, String username, String password, String email) {
        this.user = user;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserCredentials(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
