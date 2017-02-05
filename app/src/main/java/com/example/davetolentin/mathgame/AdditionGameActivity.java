package com.example.davetolentin.mathgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dave Tolentin on 2/4/2017.
 */
public class AdditionGameActivity extends AppCompatActivity implements View.OnClickListener {

    private Questions questions;
    private int num;
    private int exactAnswer;
    private String level;

    private TextView txtNum1;
    private TextView txtNum2;
    private TextView txtAnswer;
    private TextView txtchoice1;
    private TextView txtchoice3;
    private TextView txtchoice2;
    private TextView txtchoice4;

    List<Integer> indexes = new ArrayList<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_addition);

        txtNum1 = (TextView) findViewById(R.id.txtNum1);
        txtNum2 = (TextView) findViewById(R.id.txtNum2);
        txtAnswer = (TextView) findViewById(R.id.txtAnswer);
        txtchoice1 = (TextView) findViewById(R.id.txtChoice1);
        txtchoice2 = (TextView) findViewById(R.id.txtChoice2);
        txtchoice3 = (TextView) findViewById(R.id.txtChoice3);
        txtchoice4 = (TextView) findViewById(R.id.txtChoice4);

        txtNum1.setOnClickListener(this);
        txtNum2.setOnClickListener(this);
        txtAnswer.setOnClickListener(this);
        txtchoice1.setOnClickListener(this);
        txtchoice2.setOnClickListener(this);
        txtchoice3.setOnClickListener(this);
        txtchoice4.setOnClickListener(this);

        questions = new Questions();
        num = questions.generateRandomNumbers("easy");

        txtNum1.setText(String.valueOf(num));
        txtNum2.setText(String.valueOf(num));

        exactAnswer = Integer.parseInt(txtNum1.getText().toString()) +
                Integer.parseInt(txtNum2.getText().toString());

        for (int i = 0; i < 4; i++) {
            indexes.add(questions.dummyChoices(exactAnswer));
        }
        indexes.set(3, exactAnswer);

        Collections.shuffle(indexes);

        txtchoice1.setText(Integer.toString(indexes.get(0)));
        txtchoice2.setText(Integer.toString(indexes.get(1)));
        txtchoice3.setText(Integer.toString(indexes.get(2)));
        txtchoice4.setText(Integer.toString(indexes.get(3)));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
        case R.id.txtChoice1 :
                if (txtchoice1.getText().toString() == Integer.toString(exactAnswer)) {
                    txtAnswer.setText(Integer.toString(exactAnswer));
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry wrong answer",
                            Toast.LENGTH_LONG).show();
                }
            break;
        case R.id.txtChoice2 :
                if (txtchoice2.getText().toString() == Integer.toString(exactAnswer)) {
                    txtAnswer.setText(Integer.toString(exactAnswer));
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry wrong answer",
                            Toast.LENGTH_LONG).show();
                }
            break;
        case R.id.txtChoice3 :
                if (txtchoice3.getText().toString() == Integer.toString(exactAnswer)) {
                    txtAnswer.setText(Integer.toString(exactAnswer));
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry wrong answer",
                            Toast.LENGTH_LONG).show();
                }
            break;
        case R.id.txtChoice4 :
                if (txtchoice4.getText().toString() == Integer.toString(exactAnswer)) {
                    txtAnswer.setText(Integer.toString(exactAnswer));
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry wrong answer",
                            Toast.LENGTH_LONG).show();
                }
            break;
        }
    }
}