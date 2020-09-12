package com.project.wow.tankUtils;


public class TankUtils {

    // need test cases
    public static int returnRandomNumberWithinMap( String[] arrayChoices) {

            int size = arrayChoices.length-1;
            return (int)(Math.random() * ((size - 0) + 1)) + 0;
    }

    public static String getClassPick(int randomNumber, String[] arrayChoices) {
        return arrayChoices[randomNumber];
    }
}
