package com.first.appdevops_fm.controller;

import com.first.appdevops_fm.entity.Application;
import com.first.appdevops_fm.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applications")
@CrossOrigin({"http://localhost:3000"})
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.createApplication(application);
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Optional<Application> getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }
    @PutMapping("/{id}")
    public String updateApplication(@PathVariable Long id, @RequestBody Application.applicationsReq obj) {
        return applicationService.updateApplication(id, obj);
    }

    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        return applicationService.deleteApplication(id);
    }
}