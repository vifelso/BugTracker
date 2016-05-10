package com.controller;

import com.dto.BugDto;
import com.service.BugService;
import com.service.UserService;
import com.validation.BugDtoValidation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping("/bugs")
public class BugNavigation {
    @Autowired
    private UserService userService;
    @Autowired
    private BugService bugService;
    @Autowired
    private BugDtoValidation bugDtoValidation;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(bugDtoValidation);
    }

    @RequestMapping(value = "/addBug", method = RequestMethod.GET)
    public ModelAndView addBug(Model model) {
        model.addAttribute("bugDto", new BugDto());
        return new ModelAndView("addBug");
    }

    @RequestMapping(value = "/saveBugComplete", method = RequestMethod.POST)
    public ModelAndView doneSaveBug(@Valid @ModelAttribute("bugDto") BugDto bugDto, BindingResult result) throws NotFoundException {
        if (result.hasErrors()) {

            return new ModelAndView("addBug");
        }
        UserDetails userDetails = userService.getCurrentUser();
        Date date = new Date();
        bugDto.setDate(date);
        bugDto.setAutor(userDetails.getUsername());
        bugDto.setUser(userService.getUser(userDetails.getUsername()));
        bugService.addBug(bugDto);
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/watchAllBugs", method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map) {
        map.put("bugsList", bugService.getAllBugs());
        return "watch_all_bugs";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detailBug(@RequestParam(value = "id", required = true) int id, Map<String, Object> mapBug) {
        mapBug.clear();
        mapBug.put("bugDtoDetail", bugService.getBug(id));
        return new ModelAndView("detail");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editBug(@RequestParam(value = "id", required = true) int id, Map<String, Object> mapBug) {
        mapBug.clear();
        mapBug.put("bugDetailEdit", bugService.getBug(id));
        return new ModelAndView("detailEdit");
    }

    @RequestMapping(value = "/saveEditBug", method = RequestMethod.POST)
    public ModelAndView doneEditBug(@Valid @ModelAttribute("bugDetailEdit") BugDto bugDto, BindingResult result) {
        if (result.hasErrors()) {

            return new ModelAndView("detailEdit");
        }
        BugDto bugDtoEdit = bugService.getBug(bugDto.getIdBug());
        bugDtoEdit.setTitle(bugDto.getTitle());
        bugDtoEdit.setStatus(bugDto.getStatus());
        bugDtoEdit.setDesc(bugDto.getDesc());
        bugDtoEdit.setPrior(bugDto.getPrior());
        bugService.editBug(bugDtoEdit);
        return new ModelAndView("home");
    }
}
