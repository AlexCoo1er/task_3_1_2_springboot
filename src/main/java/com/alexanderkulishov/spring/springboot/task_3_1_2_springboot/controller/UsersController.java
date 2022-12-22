package com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.controller;

import com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.models.User;
import com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.serviсe.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showAll")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());

        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users/showAll";
    }

    @PatchMapping("/{id}/update")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.updateUser(user, id);
        return "redirect:/users/showAll";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {

        model.addAttribute("user", userService.getUser(id));

        return "edit-users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users/showAll";
    }


}
