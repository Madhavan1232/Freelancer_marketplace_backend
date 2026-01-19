package com.first.appdevops_fm.controller;

import com.first.appdevops_fm.entity.ClientProfile;
import com.first.appdevops_fm.service.ClientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/client-profiles")
public class ClientProfileController {

    @Autowired
    private ClientProfileService clientProfileService;

    @PostMapping
    public ClientProfile createClientProfile(@RequestBody ClientProfile clientProfile) {
        return clientProfileService.createClientProfile(clientProfile);
    }

    @GetMapping
    public List<ClientProfile> getAllClientProfiles() {
        return clientProfileService.getAllClientProfiles();
    }

    @GetMapping("/{id}")
    public Optional<ClientProfile> getClientProfileById(@PathVariable Long id) {
        return clientProfileService.getClientProfileById(id);
    }
}