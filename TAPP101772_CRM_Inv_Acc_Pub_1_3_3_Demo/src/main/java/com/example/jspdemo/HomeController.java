package com.example.jspdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home1")
    public String home1() {
        return "home1"; // resolves to /WEB-INF/views/home1.jsp
    }

    @RequestMapping(value = "")
    public String home() {
        return "healthCheck";
    }
}
