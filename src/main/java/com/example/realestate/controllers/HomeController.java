package com.example.realestate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//HomeController -> shumica e faqeve ose statike, ose faqeeve qe ska nevoje me qene i authenticuar
@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }
}
