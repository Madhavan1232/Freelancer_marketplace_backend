package com.first.appdevops_fm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "client_profiles")
@Data
public class ClientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user_id;

    @Column(nullable = false, length = 255)
    private String companyName;

    @Column(nullable = false, length = 255)
    private String contactName;

    @Column(length = 2000)
    private String bio;
    @Column(length = 1000)
    private String profilePictureUrl;
}
