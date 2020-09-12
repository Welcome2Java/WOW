package com.project.wow.healDAO;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@ConfigurationProperties(prefix = "heal.class")
@Component
public class HealDAO {

    private LinkedHashMap<String, String> healingClassOptionsMap;

    private String[] healClasses;

    public HealDAO() {
    }

    public String[] getHealClasses() {
        return healClasses;
    }

    public void setHealClasses(String[] healClasses) {
        this.healClasses = healClasses;
    }

    public LinkedHashMap<String, String> getHealingClassOptionsMap() {
        return healingClassOptionsMap;
    }

    public void setHealingClassOptionsMap(LinkedHashMap<String, String> healingClassOptionsMap) {
        this.healingClassOptionsMap = healingClassOptionsMap;
    }

}
