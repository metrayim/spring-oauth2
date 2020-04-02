package com.KSHRD.springsecurity4.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
