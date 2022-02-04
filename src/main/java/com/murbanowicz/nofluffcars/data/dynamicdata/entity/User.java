package com.murbanowicz.nofluffcars.data.dynamicdata.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "nofluffcars_service")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}