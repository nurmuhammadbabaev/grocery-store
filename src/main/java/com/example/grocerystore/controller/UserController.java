package com.example.grocerystore.controller;

import com.example.grocerystore.dto.UserRequest;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String main() {
        return "/main-page/main";
    }

    @GetMapping("/users")
    public String all(Model model) {
        List<UserResponse> users = userService.findAll();
        model.addAttribute("users", users);
        return "/user/users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") UserRequest userRequest) {
        //Страница для добавления компании в БД
        return "/user/create";
    }

    @PostMapping("/create")
    public String create(UserRequest userRequest, Model model) {
        model.addAttribute("user", userService.create(userRequest));
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "/user/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, UserRequest userRequest, Model model) {
        model.addAttribute("user", userService.update(id, userRequest));
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
