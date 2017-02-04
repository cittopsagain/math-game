package com.example.davetolentin.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dave Tolentin on 2/4/2017.
 */
public class AdditionGameActivity extends AppCompatActivity implements View.OnClickListener {

    private GenerateRandomQuestion generateRandomQuestion;
    private int num;

    private TextView txtNum1;
    private TextView txtNum2;
    private TextView txtAnswer;
    private  TextView txtchoice1;
    private  TextView txtchoice3;
    private  TextView txtchoice2;
    private  TextView txtchoice4;


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

        generateRandomQuestion = new GenerateRandomQuestion();
        num = generateRandomQuestion.generateRandomNumbers("easy");

        txtNum1.setText(String.valueOf(num));
        txtNum2.setText(String.valueOf(num));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
        case R.id.txtChoice1 :
            Toast.makeText(getApplicationContext(),"pass chocie1",Toast.LENGTH_LONG).show();
            break;
        case R.id.txtChoice2 :
            Toast.makeText(getApplicationContext(),"pass chocie2",Toast.LENGTH_LONG).show();
            break;
        case R.id.txtChoice3 :
            Toast.makeText(getApplicationContext(),"pass chocie3",Toast.LENGTH_LONG).show();
            break;
        case R.id.txtChoice4 :
            Toast.makeText(getApplicationContext(),"pass chocie4",Toast.LENGTH_LONG).show();
            break;
        }
    }

}



