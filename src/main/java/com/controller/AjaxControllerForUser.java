package com.controller;


import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class AjaxControllerForUser {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "ajaxController", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxContoller(@RequestParam(value = "uNameAjax", required = true) String nick) {
        if (userService.getUser(nick) == null) {
            return "<font color=green><b>" + nick + "</b> is available";
        } else {
            return "<font color=red><b>" + nick + "</b> is already in use</font>";

        }
    }
}
