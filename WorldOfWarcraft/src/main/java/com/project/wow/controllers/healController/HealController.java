package com.project.wow.controllers.healController;

import com.project.wow.UtilsHelper.WowUtilsHelper;
import com.project.wow.fileWrite.FileWrite;
import com.project.wow.dao.healDAO.HealDAO;
import com.project.wow.payload.Payload;
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
@RequestMapping("/heal")
public class HealController {

    @Autowired
    private HealDAO healDAO;

    @Autowired
    private WowUtilsHelper wowUtilsHelper;

    @RequestMapping("/home")
    public String showHome(Model theModel){

        theModel.addAttribute("healClassesToUse" , healDAO);

        return "Heal/healHomePage";
    }

    @RequestMapping("/showResult")
    public String showResult(HttpServletRequest request, Model model) throws IOException {
        if(null != request.getParameterValues("healClasses")){
            String[] chosenClasses = request.getParameterValues("healClasses");
            int random = wowUtilsHelper.returnRandomNumberWithinMap(chosenClasses);
            String chosenClass = StringUtils.capitalize(wowUtilsHelper.getClassPick(random,chosenClasses));

            Map<String, List<String>> specsAvailable = wowUtilsHelper.getClassSpecMap(chosenClass);
            String generatedSpec = wowUtilsHelper.pickSpecBasedOnRole(specsAvailable, "Heal", chosenClass);

            Payload payload = new Payload("Heal", chosenClass, generatedSpec);
            FileWrite.writeToFileTheResults(payload);

            model.addAttribute("chosenPick", chosenClass);
            model.addAttribute("chosenSpec", generatedSpec);

            return "Heal/result";
        } else{
            return "Heal/noPick";
        }
    }
}
