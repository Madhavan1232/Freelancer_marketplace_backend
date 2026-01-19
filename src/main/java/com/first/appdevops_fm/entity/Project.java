package com.first.appdevops_fm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
@Data

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal budget;

    @Lob
    private String requiredSkills;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Status status = Status.OPEN;

    @ManyToOne
    @JoinColumn(name = "assigned_freelancer_id")
    private User assignedFreelancer;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private Boolean isArchived = false;

    public enum Status {
        OPEN,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED
    }

    public void updateFromDto(DataTransferObject dto) {
        this.title = dto.title();
        this.description = dto.description();
        this.budget = dto.budget();
        this.requiredSkills = dto.requiredSkills();
        this.status = dto.status();
        this.isArchived = dto.isArchived();
    }
    public record DataTransferObject(
            Long id,
            String title,
            String description,
            BigDecimal budget,
            String requiredSkills,
            Status status,
            LocalDateTime createdAt,
            Boolean isArchived,
            Long clientId,
            Long assignedFreelancerId
    ) {
    }
}
