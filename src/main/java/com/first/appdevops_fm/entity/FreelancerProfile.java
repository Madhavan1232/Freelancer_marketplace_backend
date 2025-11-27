package com.first.appdevops_fm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "freelancer_profile")
@Data
public class FreelancerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastname;    

    @Column(length = 1000)
    private String bio;

    @Column(name = "hourly_rate", precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    @Column(length = 255)
    private String location;

    @Lob
    private String skills;

    @Lob
    private String portfolio;

    @Column(length = 255)
    private String portfolioUrl;
}
