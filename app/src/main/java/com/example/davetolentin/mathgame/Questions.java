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

    public int dummyChoices(int exactAnswer) {
        int n;
        n = this.random.nextInt(exactAnswer) + 1;
        return n;
    }
}