package com.duojourney.controller;

import com.duojourney.service.UserService;
import com.duojourney.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class DuojourneyController {
    UserService userService;

    @Autowired
    public DuojourneyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String getLogin(@RequestParam("user_id") Integer userId, @RequestParam("password") String password, Model model) {
        var user = userService.findById(userId);
        if (Objects.equals(password, user.getPassword())) {
            model.addAttribute("user", user);
            return "home";
        } else {
            return"login";
        }
    }
}