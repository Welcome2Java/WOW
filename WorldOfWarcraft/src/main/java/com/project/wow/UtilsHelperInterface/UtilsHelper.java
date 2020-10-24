package com.project.wow.UtilsHelperInterface;

import java.util.List;
import java.util.Map;

public interface UtilsHelper {
    public int returnRandomNumberWithinMap(String[] chosenClasses);

    public String getClassPick(int random, String[] chosenClasses);

    public Map<String, List<String>> getClassSpecMap(String chosenClasses);

    public String pickSpecBasedOnRole(Map<String, List<String>> specsAvailable, String role, String chosenClass);
}
