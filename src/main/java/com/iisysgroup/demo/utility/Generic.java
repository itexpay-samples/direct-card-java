package com.iisysgroup.demo.utility;

import java.util.Random;

public class Generic {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int REFERENCE_LENGTH = 10;

    public static String generateRandomReference() {
        StringBuilder reference = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < REFERENCE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            reference.append(randomChar);
        }

        return reference.toString();
    }

}
