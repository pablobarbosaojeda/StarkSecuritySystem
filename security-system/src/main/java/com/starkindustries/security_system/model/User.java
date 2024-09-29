package com.starkindustries.security_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Setter @Getter
    private String name;

    @Setter @Getter
    private String email;

    @Setter @Getter
    private String password;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    Roles role;

    public User() {
    }

    public User(long id, String email, String name, String password, Roles role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(String email, String name, String password, Roles role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [" +
                "Name: " + name + '\'' + "; Role:"
                + role + '\'' + "; Email:" + email +
                '\'' + "; Password:" + password
                + '\'' + " ID: " + id +
                ']';
    }
}
