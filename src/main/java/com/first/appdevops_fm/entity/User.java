package com.first.appdevops_fm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Role role;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void updateUser(Data data) {
        if (data != null) this.email = data.email;
        if (data != null) this.passwordHash = data.passwordHash;
        if (data != null) this.role = data.role;
    }

    public enum Role {
        ADMIN,
        CLIENT,
        FREELANCER
    }

    public String getPassword(){
        return this.passwordHash;
    }

    public record Data(String email, String passwordHash, Role role) {
    }
}
