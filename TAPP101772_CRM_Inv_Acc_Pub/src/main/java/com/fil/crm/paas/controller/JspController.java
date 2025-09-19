package com.fil.crm.paas.controller;

import
        com.fil.crm.paas.constants.JsonMappingConstants;
import com.fil.crm.paas.model.Employee;
import com.fil.crm.paas.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JspController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Shivam");
        return "hello";  // resolves to /WEB-INF/jsp/hello.jsp
    }

}