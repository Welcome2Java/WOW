package com.project.wow.dpsUtils;


public class DpsUtils {

    // need test cases
    public static int returnRandomNumberWithinMap( String[] arrayChoices) {

            int size = arrayChoices.length-1;
            return (int)(Math.random() * ((size - 0) + 1)) + 0;
    }

    public static String getClassPick(int randomNumber, String[] arrayChoices) {
        return arrayChoices[randomNumber];
    }
}
