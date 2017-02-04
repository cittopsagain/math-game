package com.example.davetolentin.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dave Tolentin on 2/4/2017.
 */
public class AdditionGameActivity extends AppCompatActivity implements View.OnClickListener {

    private GenerateRandomQuestion generateRandomQuestion;
    private int num;

    private TextView txtNum1;
    private TextView txtNum2;
    private TextView txtAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_addition);
        txtNum1 = (TextView) findViewById(R.id.txtNum1);
        txtNum2 = (TextView) findViewById(R.id.txtNum2);
        txtAnswer = (TextView) findViewById(R.id.txtAnswer);

        txtNum1.setOnClickListener(this);
        txtNum2.setOnClickListener(this);
        txtAnswer.setOnClickListener(this);

        generateRandomQuestion = new GenerateRandomQuestion();
        num = generateRandomQuestion.generateRandomNumbers("easy");

        txtNum1.setText(String.valueOf(num));
        txtNum2.setText(String.valueOf(num));
    }

    @Override
    public void onClick(View v) {

    }
}