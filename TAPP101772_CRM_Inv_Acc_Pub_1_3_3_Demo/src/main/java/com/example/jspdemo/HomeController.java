package com.example.jspdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/healthOk")
    @ResponseBody
    public String home(Model model) {
        return "healthCheck"; // resolves to /WEB-INF/views/healthCheck.jsp
    }
}
