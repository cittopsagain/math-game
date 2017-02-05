package com.example.davetolentin.mathgame;

import java.util.Random;

/**
 * Created by Dave Tolentin on 2/4/2017.
 */
public class Questions {

    private Random random;

    public Questions() {
        this.random = new Random();
    }

    public int generateRandomNumbers(String mode) {
        int n = 0;
        if (mode.equals("easy")) {
            // 9 is the maximum and the 0 is our minimum
            n = this.random.nextInt(9) + 0;
        }

        return n;
    }

    public int maxQuestions() {
        // maximum questions in each level
        return 5;
    }

    public int maxAttempt() {
        // maximum attempt
        return 2;
    }

    public int dummyChoices(int exactAnswer) {
        int n = 0;
        try {
            n = this.random.nextInt(exactAnswer) + 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int randomAnswerPosition() {
        int n;
        n = this.random.nextInt(3) + 0;
        return  n;
    }
    public int[] randomizeChoices(int []choiceArray) {

        Random rnd = new Random();
        for (int i = choiceArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = choiceArray[index];
            choiceArray[index] = choiceArray[i];
            choiceArray[i] = a;
        }
        return  choiceArray;
    }
}