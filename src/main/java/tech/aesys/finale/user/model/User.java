package tech.aesys.finale.user.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name = "user")
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name ="email", nullable = false)
    private String email;

    public User(){}
}
