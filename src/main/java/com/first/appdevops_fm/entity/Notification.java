package com.first.appdevops_fm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Lob
    @Column(nullable = false)
    private String message;

    private Boolean isRead = false;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
