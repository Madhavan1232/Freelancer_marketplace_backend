package com.first.appdevops_fm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "projectt_table")
@Data
public class ProjectTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long assignedFreelancerId;

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
        this.clientId = dto.clientId();
        this.assignedFreelancerId = dto.assignedFreelancerId();
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
