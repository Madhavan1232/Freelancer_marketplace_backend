package com.first.appdevops_fm.service;

import com.first.appdevops_fm.entity.ClientProfile;
import com.first.appdevops_fm.repository.ClientProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientProfileService {

    @Autowired
    private ClientProfileRepository clientProfileRepository;

    public ClientProfile createClientProfile(ClientProfile clientProfile) {
        return clientProfileRepository.save(clientProfile);
    }

    public List<ClientProfile> getAllClientProfiles() {
        return clientProfileRepository.findAll();
    }

    public Optional<ClientProfile> getClientProfileById(Long id) {
        return clientProfileRepository.findById(id);
    }
}