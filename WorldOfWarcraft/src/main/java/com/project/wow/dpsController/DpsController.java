package com.project.wow.dpsController;

import com.project.wow.dpsDAO.DpsDAO;
import com.project.wow.dpsUtils.DpsUtils;
import com.project.wow.fileWrite.FileWrite;
import com.project.wow.payload.Payload;
import com.project.wow.tankUtils.TankUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/dps")
public class DpsController {

    @Autowired
    private DpsDAO dpsDAO;

    @RequestMapping("/home")
    public String showHome(Model model) {

        model.addAttribute("dpsClassesToUse", dpsDAO);
        return "DPS/dpsHomePage";
    }

    @RequestMapping("/showResult")
    public String showResult(HttpServletRequest request, Model model) throws IOException {
        if(null != request.getParameterValues("dpsClasses")){
            String[] chosenClasses = request.getParameterValues("dpsClasses");
            int random = DpsUtils.returnRandomNumberWithinMap(chosenClasses);
            String chosenClass = StringUtils.capitalize(DpsUtils.getClassPick(random,chosenClasses));
            Payload payload = new Payload("Dps", chosenClass);
            FileWrite.writeToFileTheResults(payload);
            model.addAttribute("chosenPick", chosenClass);

            return "DPS/result";
        } else{
            return "DPS/noPick";
        }
    }
}
