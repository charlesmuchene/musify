package dev.cstv.musify.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GroupToo")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    List<Authority> authority = new ArrayList<Authority>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    List<UserCredentials> userCredentials = new ArrayList<UserCredentials>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }

    public List<UserCredentials> getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(List<UserCredentials> userCredentials) {
        this.userCredentials = userCredentials;
    }
}
