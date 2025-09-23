package com.fil.crm.paas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JspController {

    @GetMapping("/hello")
    public String hello(Model model) {
        //model.addAttribute("name", "Shivam");
        return "hello";  // resolves to /WEB-INF/jsp/hello.jsp
    }
}