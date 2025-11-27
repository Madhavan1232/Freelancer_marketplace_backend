package com.first.appdevops_fm.controller;

import com.first.appdevops_fm.entity.FreelancerProfile;
import com.first.appdevops_fm.service.FreelancerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/freelancer-profile")
@CrossOrigin(origins = "*")
public class FreelancerProfileController {

    @Autowired
    private FreelancerProfileService freelancerProfileService;

    @PostMapping
    public FreelancerProfile createFreelancerProfile(@RequestBody FreelancerProfile freelancerProfile) {
        return freelancerProfileService.createFreelancerProfile(freelancerProfile);
    }

    @GetMapping
    public List<FreelancerProfile> getAllFreelancerProfiles() {
        return freelancerProfileService.getAllFreelancerProfiles();
    }
}