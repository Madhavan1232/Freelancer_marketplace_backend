package com.first.appdevops_fm.controller;

import com.first.appdevops_fm.entity.User;
import com.first.appdevops_fm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public String updateUserById(@PathVariable Long id, @RequestBody User.Data user) {
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public String removeUserById(@PathVariable Long id) {
        return userService.removeUserById(id);
    }

    @GetMapping("/getUsers")
    public String getUserByEmail(@RequestParam String email) {
        boolean isEmailExist = userService.checkEmailExists(email);
        return isEmailExist ? "Email Exists!" : "Email Doesn't Exist!";
    }

    @GetMapping("/getPassword")
    public String getPassword(@RequestParam String email, String password) {
        boolean isPassWordForTheEmail = userService.checkPassWord(email , password);
        return isPassWordForTheEmail ? "Password Exist!" : "Password Doesn't Exist!" + password;
    }
    @GetMapping("/getUserByEmail")
    public List<User> getUserByemail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

}