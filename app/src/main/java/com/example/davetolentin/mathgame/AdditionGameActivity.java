package com.example.davetolentin.mathgame;

import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by Dave Tolentin on 2/4/2017.
 */
public class AdditionGameActivity extends AppCompatActivity implements View.OnClickListener {

    private Questions questions;
    private SessionManager sessionManager;
    private SharedPreferences sharedPreferences;
    private DialogHelper dialogHelper;
    private int num;
    private int exactAnswer;
    private int remainingAttempt;
    private int ctr = 0;

    private TextView txtNum1;
    private TextView txtNum2;
    private TextView txtAnswer;
    private TextView txtChoice1;
    private TextView txtChoice2;
    private TextView txtChoice3;
    private TextView txtChoice4;
    private TextView txtAttempt;


    private int[] choiceArray = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_addition);

        txtNum1 = (TextView) findViewById(R.id.txtNum1);
        txtNum2 = (TextView) findViewById(R.id.txtNum2);
        txtAnswer = (TextView) findViewById(R.id.txtAnswer);
        txtChoice1 = (TextView) findViewById(R.id.txtChoice1);
        txtChoice2 = (TextView) findViewById(R.id.txtChoice2);
        txtChoice3 = (TextView) findViewById(R.id.txtChoice3);
        txtChoice4 = (TextView) findViewById(R.id.txtChoice4);
        txtAttempt = (TextView) findViewById(R.id.txtAttempt);

        txtNum1.setOnClickListener(this);
        txtNum2.setOnClickListener(this);
        txtAnswer.setOnClickListener(this);
        txtChoice1.setOnClickListener(this);
        txtChoice2.setOnClickListener(this);
        txtChoice3.setOnClickListener(this);
        txtChoice4.setOnClickListener(this);

        questions = new Questions();
        sessionManager = new SessionManager(getApplicationContext());
        sharedPreferences = getSharedPreferences("LaundryShop", Context.MODE_PRIVATE);
        dialogHelper = new DialogHelper(AdditionGameActivity.this);

        if (sharedPreferences.getString("keyLevel", "").equals("")) {
            // first level of the game
            num = questions.generateRandomNumbers("easy");
        } else {
            num = questions.generateRandomNumbers(sharedPreferences.getString("keyLevel", ""));
        }

        txtNum1.setText(String.valueOf(num));
        txtNum2.setText(String.valueOf(num));
        txtAttempt.setText(String.valueOf(questions.maxAttempt()));

        remainingAttempt = Integer.parseInt(txtAttempt.getText().toString());

        exactAnswer = Integer.parseInt(txtNum1.getText().toString()) +
                Integer.parseInt(txtNum2.getText().toString());

        for(int c = 0;c<choiceArray.length-1;c++){
            choiceArray[c] = exactAnswer + c + 1;

        }
        choiceArray[choiceArray.length-1] = exactAnswer;
        choiceArray  =  questions.randomize_choices(choiceArray);



        txtChoice1.setText(Integer.toString(choiceArray[0]));
        txtChoice2.setText(Integer.toString(choiceArray[1]));
        txtChoice3.setText(Integer.toString(choiceArray[2]));
        txtChoice4.setText(Integer.toString(choiceArray[3]));

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.txtChoice1 :
            if (txtChoice1.getText().toString() == Integer.toString(exactAnswer)) {
                txtAnswer.setText(Integer.toString(exactAnswer));
            } else {
                txtChoice1.setText("X");
                if (ctr++ == 1) {
                    remainingAttempt -= 1;
                    txtAttempt.setText(String.valueOf(remainingAttempt));
                    dialogHelper.showDialog("Alert", "Play again", "Cancel", "You already" +
                                    " used all your attempts", false,
                            new DialogHelper.AlertDialogListener<Integer>() {
                                @Override
                                public void onSuccess(int t) {
                                    if (t == 1) {
                                        // Play again
                                        txtAttempt.setText(String.valueOf(questions.maxAttempt()));
                                        txtNum1.setText(String.valueOf(
                                                questions.generateRandomNumbers("easy")
                                        ));
                                        txtNum2.setText(String.valueOf(
                                                questions.generateRandomNumbers("easy"))
                                        );
                                        exactAnswer = Integer.parseInt(txtNum1.getText().toString())
                                                + Integer.parseInt(txtNum2.getText().toString());
                                        for (int i = 0; i < choiceArray.length; i++) {
                                            choiceArray[i]= questions.dummyChoices(exactAnswer);
                                        }
                                        choiceArray[choiceArray.length-1] = exactAnswer;

                                        choiceArray = questions.randomize_choices(choiceArray);

                                        txtChoice1.setText(Integer.toString(choiceArray[0]));
                                        txtChoice2.setText(Integer.toString(choiceArray[1]));
                                        txtChoice3.setText(Integer.toString(choiceArray[2]));
                                        txtChoice4.setText(Integer.toString(choiceArray[3]));

                                        remainingAttempt = questions.maxAttempt();
                                        ctr = 0;
                                    } else {
                                        // Cancel
                                        Intent intent = new Intent(getApplicationContext(),
                                                GameCategoryActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                } else {
                    remainingAttempt -= 1;
                    txtAttempt.setText(String.valueOf(remainingAttempt));
                }
            }
            break;
        case R.id.txtChoice2 :
            if (txtChoice2.getText().toString() == Integer.toString(exactAnswer)) {
                txtAnswer.setText(Integer.toString(exactAnswer));
            } else {
                txtChoice2.setText("X");
                if (ctr++ == 1) {
                    remainingAttempt -= 1;
                    txtAttempt.setText(String.valueOf(remainingAttempt));
                    dialogHelper.showDialog("Alert", "Play again", "Cancel", "You already" +
                                    " used all your attempts", false,
                            new DialogHelper.AlertDialogListener<Integer>() {
                                @Override
                                public void onSuccess(int t) {
                                    if (t == 1) {
                                        // Play again
                                        txtAttempt.setText(String.valueOf(questions.maxAttempt()));
                                        txtNum1.setText(String.valueOf(
                                                questions.generateRandomNumbers("easy")
                                        ));
                                        txtNum2.setText(String.valueOf(
                                                questions.generateRandomNumbers("easy"))
                                        );
                                        exactAnswer = Integer.parseInt(txtNum1.getText().toString())
                                                + Integer.parseInt(txtNum2.getText().toString());
                                        for (int i = 0; i < choiceArray.length; i++) {
                                            choiceArray[i]= questions.dummyChoices(exactAnswer);
                                        }
                                        choiceArray[choiceArray.length-1] = exactAnswer;

                                        choiceArray = questions.randomize_choices(choiceArray);

                                        txtChoice1.setText(Integer.toString(choiceArray[0]));
                                        txtChoice2.setText(Integer.toString(choiceArray[1]));
                                        txtChoice3.setText(Integer.toString(choiceArray[2]));
                                        txtChoice4.setText(Integer.toString(choiceArray[3]));

                                        remainingAttempt = questions.maxAttempt();
                                        ctr = 0;
                                    } else {
                                        // Cancel
                                        Intent intent = new Intent(getApplicationContext(),
                                                GameCategoryActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                } else {
                    remainingAttempt -= 1;
                    txtAttempt.setText(String.valueOf(remainingAttempt));
                }
            }
            break;
        case R.id.txtChoice3 :
            if (txtChoice3.getText().toString() == Integer.toString(exactAnswer)) {
                txtAnswer.setText(Integer.toString(exactAnswer));
            } else {
                txtChoice3.setText("X");
                if (ctr++ == 1) {
                    remainingAttempt -= 1;
                    txtAttempt.setText(String.valueOf(remainingAttempt));
                    dialogHelper.showDialog("Alert", "Play again", "Cancel", "You already" +
                                    " used all your attempts", false,
                            new DialogHelper.AlertDialogListener<Integer>() {
                                @Override
                                public void onSuccess(int t) {
                                    if (t == 1) {
                                        // Play again
                                        txtAttempt.setText(String.valueOf(questions.maxAttempt()));
                                        txtNum1.setText(String.valueOf(
                                                questions.generateRandomNumbers("easy")
                                        ));
                                        txtNum2.setText(String.valueOf(
                                                questions.generateRandomNumbers("easy"))
                                        );
                                        exactAnswer = Integer.parseInt(txtNum1.getText().toString())
                                                + Integer.parseInt(txtNum2.getText().toString());
                                        for (int i = 0; i < choiceArray.length; i++) {
                                            choiceArray[i]= questions.dummyChoices(exactAnswer);
                                        }
                                        choiceArray[choiceArray.length-1] = exactAnswer;

                                        choiceArray = questions.randomize_choices(choiceArray);

                                        txtChoice1.setText(Integer.toString(choiceArray[0]));
                                        txtChoice2.setText(Integer.toString(choiceArray[1]));
                                        txtChoice3.setText(Integer.toString(choiceArray[2]));
                                        txtChoice4.setText(Integer.toString(choiceArray[3]));

                                        remainingAttempt = questions.maxAttempt();
                                        ctr = 0;
                                    } else {
                                        // Cancel
                                        Intent intent = new Intent(getApplicationContext(),
                                                GameCategoryActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                } else {
                    remainingAttempt -= 1;
                    txtAttempt.setText(String.valueOf(remainingAttempt));
                }
            }
            break;
        case R.id.txtChoice4 :
            if (txtChoice4.getText().toString() == Integer.toString(exactAnswer)) {
                txtAnswer.setText(Integer.toString(exactAnswer));
            } else {
                txtChoice4.setText("X");
                if (ctr++ == 1) {
                    remainingAttempt -= 1;
                    txtAttempt.setText(String.valueOf(remainingAttempt));
                    dialogHelper.showDialog("Alert", "Play again", "Cancel", "You already" +
                                    " used all your attempts", false,
                            new DialogHelper.AlertDialogListener<Integer>() {
                                @Override
                                public void onSuccess(int t) {
                                    if (t == 1) {
                                        // Play again
                                        txtAttempt.setText(String.valueOf(questions.maxAttempt()));
                                        txtNum1.setText(String.valueOf(
                                                questions.generateRandomNumbers("easy")
                                        ));
                                        txtNum2.setText(String.valueOf(
                                                questions.generateRandomNumbers("easy"))
                                        );
                                        exactAnswer = Integer.parseInt(txtNum1.getText().toString())
                                                + Integer.parseInt(txtNum2.getText().toString());
                                        for (int i = 0; i < choiceArray.length; i++) {
                                            choiceArray[i]= questions.dummyChoices(exactAnswer);
                                        }
                                        choiceArray[choiceArray.length-1] = exactAnswer;

                                        choiceArray = questions.randomize_choices(choiceArray);

                                        txtChoice1.setText(Integer.toString(choiceArray[0]));
                                        txtChoice2.setText(Integer.toString(choiceArray[1]));
                                        txtChoice3.setText(Integer.toString(choiceArray[2]));
                                        txtChoice4.setText(Integer.toString(choiceArray[3]));

                                        remainingAttempt = questions.maxAttempt();
                                        ctr = 0;
                                    } else {
                                        // Cancel
                                        Intent intent = new Intent(getApplicationContext(),
                                                GameCategoryActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                } else {
                    remainingAttempt -= 1;
                    txtAttempt.setText(String.valueOf(remainingAttempt));
                }
            }
            break;
        }
    }
}