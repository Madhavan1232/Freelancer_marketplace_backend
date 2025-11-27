package com.first.appdevops_fm.service;

import com.first.appdevops_fm.entity.User;
import com.first.appdevops_fm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String removeUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "User deleted";
        } else {
            return "User not found";
        }
    }

    public String createUser(User user) {
        userRepository.save(user);
        return "User created";
    }

    public String updateUserById(Long id, User.Data user) {
        if (userRepository.findById(id).isPresent()) {
            User existingUser = userRepository.findById(id).get();
            existingUser.updateUser(user);
            userRepository.save(existingUser);
            return "User updated";
        } else {
            return "User not found";
        }
    }

    public boolean checkEmailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean checkPassWord(String email, String password) {
        String ExistingPassword = userRepository.findByEmail(email).get().getPassword();
        if (password.equals(ExistingPassword)) {
            System.out.println("FROM PASSWORD " + password);
            System.out.println("Existing Password " + ExistingPassword);
            return true;
        } else {
            return false;
        }
    }

    public List<User> getUserByEmail(String email) {
        if(userRepository.findByEmail(email).isPresent()){
            return userRepository.findAll();
        }else{
            return null;
        }
    }
}