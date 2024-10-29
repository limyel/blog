package com.limyel.blog.controller;

import com.limyel.blog.model.entity.UserEntity;
import com.limyel.blog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminPageController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("admin/login");
        mv.addObject("request", request);
        return mv;
    }

    @PostMapping("/do-login")
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        UserEntity user = userService.doLogin(username, password);
        if (user == null) {
            return "redirect:/admin/login";
        }
        return "redirect:/admin/index";
    }

    @GetMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("admin/index");
        mv.addObject("request", request);
        return mv;
    }

}
