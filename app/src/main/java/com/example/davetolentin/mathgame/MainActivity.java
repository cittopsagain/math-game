package com.example.davetolentin.mathgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNewGame;
    private Button btnSettings;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnExit = (Button) findViewById(R.id.btnExit);

        btnNewGame.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNewGame) {
            Intent intent = new Intent(getApplicationContext(), GameCategoryActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btnSettings) {

        } else {

        }
    }
}