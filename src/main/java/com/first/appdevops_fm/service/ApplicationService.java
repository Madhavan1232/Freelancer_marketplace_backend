package com.first.appdevops_fm.service;

import com.first.appdevops_fm.entity.Application;
import com.first.appdevops_fm.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }


    public String updateApplication(Long id, Application.applicationsReq obj) {
        if(applicationRepository.findById(id).isPresent()) {
            Application existingApplication = applicationRepository.findById(id).get();
            existingApplication.setProposalMessage(obj.proposalMessage());
            applicationRepository.save(existingApplication);
            return "Application updated successfully.";
        }else{
            return "Application not found.";
        }
    }

    public String deleteApplication(Long id) {
        if(applicationRepository.findById(id).isPresent()) {
            applicationRepository.deleteById(id);
            return "Application deleted successfully.";
        }else{
            return "Application not found.";
        }
    }
}