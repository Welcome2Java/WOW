package com.project.wow.controllers.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private String homepage = "HomePage/homePage";

    @RequestMapping("/")
    public String homePage(){
        return homepage;
    }
}
