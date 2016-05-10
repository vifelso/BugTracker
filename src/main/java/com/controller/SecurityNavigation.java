package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SecurityNavigation {
    @RequestMapping(value = "user-login", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        return new ModelAndView("login-form");
    }

    @RequestMapping(value = "error-login", method = RequestMethod.GET)
    public ModelAndView invalidLogin() {
        return new ModelAndView("login-form");
    }

    @RequestMapping(value = "success-login", method = RequestMethod.GET)
    public ModelAndView successLogin() {
        return new ModelAndView("success-login");
    }

}
