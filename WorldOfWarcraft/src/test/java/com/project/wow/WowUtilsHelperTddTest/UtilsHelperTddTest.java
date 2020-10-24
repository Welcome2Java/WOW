package com.project.wow.WowUtilsHelperTddTest;

import com.project.wow.UtilsHelper.WowUtilsHelper;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilsHelperTddTest extends java.lang.Object{

    private  WowUtilsHelper wowUtilsHelper = new WowUtilsHelper();

    @Test
    public void randomNumberShouldReturnWithinGivenRange(){
        String array[] = {"test", "test", "test", "test"};
        int random  = wowUtilsHelper.returnRandomNumberWithinMap(array);

        assertTrue(random <= array.length);
    }

    @Test
    public void returnsAClassWithinTheArray(){
        String array[] = {"Shaman", "Monk", "Druid", "Paladin", "Priest"};
        int random = 3;
        String className = wowUtilsHelper.getClassPick(random, array);

        assertEquals(className, array[random]);
    }

    @Test
    public void populateClassSpecMap(){
        Map<String, List<String>> classSpecMap = new HashMap<>();
        classSpecMap = wowUtilsHelper.getClassSpecMap("Demon Hunter");
        List<String> classChosenSpecList = classSpecMap.get("Demon Hunter");

        assertEquals(2, classChosenSpecList.size());
    }

    @Test
    public void getSpecForChosenClass(){
        Map<String, List<String>> specsAvailable = wowUtilsHelper.getClassSpecMap("Paladin");
        String generatedSpec = wowUtilsHelper.pickSpecBasedOnRole(specsAvailable, "DPS", "Paladin");

        assertEquals("Retribution" ,generatedSpec);
    }
}
