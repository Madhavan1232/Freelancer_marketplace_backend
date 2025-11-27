package com.first.appdevops_fm.repository;

import com.first.appdevops_fm.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
