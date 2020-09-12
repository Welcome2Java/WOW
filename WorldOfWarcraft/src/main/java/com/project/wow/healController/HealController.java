package com.project.wow.healController;

import com.project.wow.fileWrite.FileWrite;
import com.project.wow.healDAO.HealDAO;
import com.project.wow.healUtils.HealUtils;
import com.project.wow.payload.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/heal")
public class HealController {

    @Autowired
    private HealDAO healDAO;

    @RequestMapping("/home")
    public String showHome(Model theModel){

        theModel.addAttribute("healClassesToUse" , healDAO);

        return "Heal/healHomePage";
    }

    @RequestMapping("/showResult")
    public String showResult(HttpServletRequest request, Model model) throws IOException {
        if(null != request.getParameterValues("healClasses")){
            String[] chosenClasses = request.getParameterValues("healClasses");
            int random = HealUtils.returnRandomNumberWithinMap(chosenClasses);
            String chosenClass = StringUtils.capitalize(HealUtils.getClassPick(random,chosenClasses));
            Payload payload = new Payload("Heal", chosenClass);
            FileWrite.writeToFileTheResults(payload);
            model.addAttribute("chosenPick", chosenClass);

            return "Heal/result";
        } else{
            return "Heal/noPick";
        }
    }
}
