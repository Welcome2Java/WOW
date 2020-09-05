package com.project.wow.mainmenuController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainMenu {

    private String mainMenu = "MainMenu/mainMenu";

    @RequestMapping("/menu")
    public String mainMenu(){
        return mainMenu;
    }
}
