package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final List<User> userList = new ArrayList<>();

    @PostMapping("/create")
    public String create(User user) {
        System.out.println(user);
        userList.add(user);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        userList.forEach(System.out::println);
        model.addAttribute("userList", userList);
        return "list";
    }
}
