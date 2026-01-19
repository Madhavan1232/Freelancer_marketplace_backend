package com.first.appdevops_fm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Data
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private User freelancer;

    @Lob
    @Column(nullable = false)
    private String proposalMessage;

    public void setProposalMessage(String proposalMessage) {
        this.proposalMessage = proposalMessage;
    }

    @CreationTimestamp
    private LocalDateTime createdAt;

    public record applicationsReq(Long projectId, Long freelancerId, String proposalMessage) {}
}
