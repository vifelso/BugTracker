package com.controller;


import com.dto.RoleDto;
import com.dto.UserDto;
import com.service.*;
import com.validation.UserDtoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UserNavigation {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserDtoValidation userDtoValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userDtoValidator);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "account", method = RequestMethod.GET)
    public ModelAndView accountPage() {
        return new ModelAndView("account");
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView registerPagePost() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "doneRegistration", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute("user") UserDto userDto,
                                BindingResult result) {
        if (result.hasErrors()) {

            return new ModelAndView("register");
        }
        if (userService.getUser(userDto.getLogin()) == null) {

            RoleDto roleDto = roleService.getRole(4);
            userDto.setRole(roleDto);
            userService.addUser(userDto);
            return new ModelAndView("home");

        } else return new ModelAndView("register");

    }

}
