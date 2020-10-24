package com.project.wow.controllers.dpsController;

import com.project.wow.UtilsHelper.WowUtilsHelper;
import com.project.wow.dao.dpsDAO.DpsDAO;
import com.project.wow.fileWrite.FileWrite;
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
@RequestMapping("/dps")
public class DpsController {

    @Autowired
    private DpsDAO dpsDAO;

    @Autowired
    private WowUtilsHelper wowUtilsHelper;

    @RequestMapping("/home")
    public String showHome(Model model) {

        model.addAttribute("dpsClassesToUse", dpsDAO);
        return "DPS/dpsHomePage";
    }

    @RequestMapping("/showResult")
    public String showResult(HttpServletRequest request, Model model) throws IOException {
        if(null != request.getParameterValues("dpsClasses")){
            String[] chosenClasses = request.getParameterValues("dpsClasses");
            int random = wowUtilsHelper.returnRandomNumberWithinMap(chosenClasses);
            String chosenClass = StringUtils.capitalize(wowUtilsHelper.getClassPick(random,chosenClasses));

            String[] classNameArray = chosenClass.split("(?=\\p{Upper})");
            if(classNameArray.length >1){
                chosenClass = classNameArray[0] + " " + classNameArray[1];
            }

            Map<String, List<String>> specsAvailable = wowUtilsHelper.getClassSpecMap(chosenClass);
            String generatedSpec = wowUtilsHelper.pickSpecBasedOnRole(specsAvailable, "DPS", chosenClass);

            Payload payload = new Payload("Dps", chosenClass, generatedSpec);
            FileWrite.writeToFileTheResults(payload);

            model.addAttribute("chosenPick", chosenClass);
            model.addAttribute("chosenSpec", generatedSpec);

            return "DPS/result";
        } else{
            return "DPS/noPick";
        }
    }
}
