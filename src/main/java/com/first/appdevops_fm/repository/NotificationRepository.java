package com.first.appdevops_fm.repository;

import com.first.appdevops_fm.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
