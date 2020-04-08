package com.KSHRD.springsecurity4.Controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api")
@Api( value = "Employee Management System", description = "Operations pertaining to employee in Employee ")
public class MainController {
    @GetMapping("/secure")
        public String secure(){
        return "This for route Secure";
        }
    @GetMapping("/unsecure")
    public String unsecure(){
        return "this for route secure note secureC";
    }
}
