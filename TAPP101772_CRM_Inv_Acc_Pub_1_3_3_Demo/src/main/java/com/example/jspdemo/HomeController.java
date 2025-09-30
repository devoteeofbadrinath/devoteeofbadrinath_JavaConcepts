package com.example.jspdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/healthOk")
    public String home(Model model) {
        model.addAttribute("message", "Service is OK");
        return "healthCheck"; // resolves to /WEB-INF/views/healthCheck.jsp
    }
}
