package com.project.wow.dpsDAO;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
@ConfigurationProperties(prefix = "dps.class")
public class DpsDAO {

    private LinkedHashMap<String, String> dpsClassOptionsMap;

    private String[] dpsClasses;

    public DpsDAO() {

    }


    public LinkedHashMap<String, String> getDpsClassOptionsMap() {
        return dpsClassOptionsMap;
    }

    public void setDpsClassOptionsMap(LinkedHashMap<String, String> dpsClassOptionsMap) {
        this.dpsClassOptionsMap = dpsClassOptionsMap;
    }

    public String[] getDpsClasses() {
        return dpsClasses;
    }

    public void setDpsClasses(String[] dpsClasses) {
        this.dpsClasses = dpsClasses;
    }
}
