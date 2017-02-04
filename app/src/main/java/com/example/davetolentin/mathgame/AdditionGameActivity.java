package com.example.davetolentin.mathgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dave Tolentin on 2/4/2017.
 */
public class AdditionGameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNum1;
    private TextView txtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_addition);
    }

    @Override
    public void onClick(View v) {

    }
}
