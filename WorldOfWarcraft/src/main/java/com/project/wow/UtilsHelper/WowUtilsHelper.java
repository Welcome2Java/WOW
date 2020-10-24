package com.project.wow.UtilsHelper;


import com.project.wow.UtilsHelperInterface.UtilsHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

@Component
public class WowUtilsHelper implements UtilsHelper {

    @Override
    public int returnRandomNumberWithinMap(String[] chosenClasses) {
        int size = chosenClasses.length;
        Random rand = new Random();
        int randomNumber = rand.nextInt(size);
        return randomNumber;
    }

    @Override
    public String getClassPick(int random, String[] chosenClasses) {
        return chosenClasses[random];
    }

    @Override
    public Map<String, List<String>> getClassSpecMap(String chosenClasses) {
        Map<String, List<String>> classSpecMap = new HashMap<>();
        List<String> specList = new ArrayList<>();
        try{
            File file = new File("ClassSpecification.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                String[] classSpecMatch = data.split("=");
                if(classSpecMatch != null && classSpecMatch.length > 1){
                    String className = classSpecMatch[0].trim();
                    String classSpec = classSpecMatch[1].trim();
                    if(chosenClasses.equals(className)){
                        specList.add(classSpec);
                    }
                }
            }
            classSpecMap.put(chosenClasses, specList);
            reader.close();
        } catch(Exception e){
            System.out.println("Can not read file" + e);
        }
        return classSpecMap;
    }

    @Override
    public String pickSpecBasedOnRole(Map<String, List<String>> specsAvailable, String role, String chosenClass) {
        List<String> availableSpecForTheClass = new ArrayList<>();

        List<String> classChosenSpecList = specsAvailable.get(chosenClass);
        for (String specs : classChosenSpecList) {
            if (specs.contains(role.toLowerCase())) {
                String specCleaned = specs.substring(0, specs.indexOf('(')).trim();
                availableSpecForTheClass.add(specCleaned);
            }
        }
        int size = availableSpecForTheClass.size();
        if (size == 1) {
            return availableSpecForTheClass.get(0);
        } else {
            Random rand = new Random();
            int randomNumber = rand.nextInt(size);
            return availableSpecForTheClass.get(randomNumber);
        }
    }
}
