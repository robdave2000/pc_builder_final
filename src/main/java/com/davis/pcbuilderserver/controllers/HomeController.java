package com.davis.pcbuilderserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HomeController {
    @GetMapping("/")
    public RedirectView redirectToLogin(){
        return new RedirectView("http://localhost:8080/register.html");
    }
}
