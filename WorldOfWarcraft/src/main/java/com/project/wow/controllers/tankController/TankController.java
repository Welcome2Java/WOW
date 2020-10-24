package com.project.wow.controllers.tankController;


import com.project.wow.UtilsHelper.WowUtilsHelper;
import com.project.wow.fileWrite.FileWrite;
import com.project.wow.payload.Payload;
import com.project.wow.dao.tankDAO.TankDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tank")
public class TankController {

    @Autowired
    private TankDAO tankDao;

    @Autowired
    private WowUtilsHelper wowUtilsHelper;

    @RequestMapping("/home")
    public String showHome(Model theModel){

        theModel.addAttribute("tankClassesToUse" , tankDao);

        return "Tank/tankHomePage";
    }

    @RequestMapping("/showResult")
    public String showResult(HttpServletRequest request, Model model) throws IOException {
        if(null != request.getParameterValues("tankClasses")){
            String[] chosenClasses = request.getParameterValues("tankClasses");
            int random = wowUtilsHelper.returnRandomNumberWithinMap(chosenClasses);
            String chosenClass = StringUtils.capitalize(wowUtilsHelper.getClassPick(random,chosenClasses));
            String[] classNameArray = chosenClass.split("(?=\\p{Upper})");
            if(classNameArray.length >1){
                chosenClass = classNameArray[0] + " " + classNameArray[1];
            }

            Map<String, List<String>> specsAvailable = wowUtilsHelper.getClassSpecMap(chosenClass);
            String generatedSpec = wowUtilsHelper.pickSpecBasedOnRole(specsAvailable, "TANk", chosenClass);

            Payload payload = new Payload("Tank", chosenClass, generatedSpec);
            FileWrite.writeToFileTheResults(payload);

            model.addAttribute("chosenPick", chosenClass);
            model.addAttribute("chosenSpec", generatedSpec);

            return "Tank/result";
        } else{
            return "Tank/noPick";
        }
    }
}
