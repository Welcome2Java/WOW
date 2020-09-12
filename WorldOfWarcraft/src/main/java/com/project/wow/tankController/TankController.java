package com.project.wow.tankController;


import com.project.wow.fileWrite.FileWrite;
import com.project.wow.payload.Payload;
import com.project.wow.tankDAO.TankDAO;
import com.project.wow.tankUtils.TankUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/tank")
public class TankController {

    @Autowired
    private TankDAO tankDao;

    @RequestMapping("/home")
    public String showHome(Model theModel){

        theModel.addAttribute("tankClassesToUse" , tankDao);

        return "Tank/tankHomePage";
    }

    @RequestMapping("/showResult")
    public String showResult(HttpServletRequest request, Model model) throws IOException {
        if(null != request.getParameterValues("tankClasses")){
            String[] chosenClasses = request.getParameterValues("tankClasses");
            int random = TankUtils.returnRandomNumberWithinMap(chosenClasses);
            String chosenClass = StringUtils.capitalize(TankUtils.getClassPick(random,chosenClasses));
            Payload payload = new Payload("Tank", chosenClass);
            FileWrite.writeToFileTheResults(payload);
            model.addAttribute("chosenPick", chosenClass);

            return "Tank/result";
        } else{
            return "Tank/noPick";
        }
    }
}
