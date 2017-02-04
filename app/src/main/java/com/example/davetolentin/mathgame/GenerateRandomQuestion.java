package com.example.davetolentin.mathgame;

import java.util.Random;

/**
 * Created by Dave Tolentin on 2/4/2017.
 */
public class GenerateRandomQuestion {

    private Random random;

    public GenerateRandomQuestion() {
        this.random = new Random();
    }

    public int generateRandomNumbers(String mode) {
        int n = 0;
        if (mode.equals("easy")) {
            // 9 is the maximum and the 0 is our minimum
            n = this.random.nextInt(9) + 0;
        }
        if (mode.equals("medium")){
            // 20 is the maximum and 10 is our minimum
            n = this.random.nextInt(20) + 10;
        }
        return n;
    }
}