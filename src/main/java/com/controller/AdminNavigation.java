package com.controller;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class AdminNavigation {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public ModelAndView adminAccess(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return new ModelAndView("admin");
    }
}
