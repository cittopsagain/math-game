package com.example.davetolentin.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dave Tolentin on 2/4/2017.
 */
public class GameCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAddition;
    private Button btnSubtraction;
    private Button btnChainSequence;
    private Button btnSymbols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_category);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnChainSequence = (Button) findViewById(R.id.btnChainSequence);
        btnSymbols = (Button) findViewById(R.id.btnSymbols);

        btnAddition.setOnClickListener(this);
        btnSubtraction.setOnClickListener(this);
        btnChainSequence.setOnClickListener(this);
        btnSymbols.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddition) {
            Intent intent = new Intent(getApplicationContext(), AdditionGameActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btnSubtraction) {

        } else if (v.getId() == R.id.btnChainSequence) {

        } else {

        }
    }
}