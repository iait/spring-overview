package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingCtrl {

    @GetMapping("greeting")
    public String greeting(Map<String, Object> model) {

        model.put("message", "Hello John");
        return "greeting";
    }

}
