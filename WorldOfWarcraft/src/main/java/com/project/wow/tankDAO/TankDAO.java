package com.project.wow.tankDAO;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.LinkedHashMap;


@ConfigurationProperties(prefix = "tank.class")
@Component
public class TankDAO {

    private LinkedHashMap<String, String> tankingClassOptionsMap;

    private String[] tankClasses;

    public TankDAO() {

    }

    public LinkedHashMap<String, String> getTankingClassOptionsMap() {
        return tankingClassOptionsMap;
    }

    public void setTankingClassOptionsMap(LinkedHashMap<String, String> tankingClassOptionsMap) {
        this.tankingClassOptionsMap = tankingClassOptionsMap;
    }

    public String[] getTankClasses() {
        return tankClasses;
    }

    public void setTankClasses(String[] tankClasses) {
        this.tankClasses = tankClasses;
    }
}
