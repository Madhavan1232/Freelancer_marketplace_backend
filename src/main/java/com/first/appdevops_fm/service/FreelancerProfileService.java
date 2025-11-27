package com.first.appdevops_fm.service;

import com.first.appdevops_fm.entity.FreelancerProfile;
import com.first.appdevops_fm.repository.FreelancerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreelancerProfileService {

    @Autowired
    private FreelancerProfileRepository freelancerProfileRepository;

    public FreelancerProfile createFreelancerProfile(FreelancerProfile freelancerProfile) {
        return freelancerProfileRepository.save(freelancerProfile);
    }

    public List<FreelancerProfile> getAllFreelancerProfiles() {
        return freelancerProfileRepository.findAll();
    }

}