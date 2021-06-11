package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private Button btnCharacter;
    private Button btnEpisodes;
    private Button btnLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCharacter = findViewById(R.id.btnCharacter);
        btnEpisodes = findViewById(R.id.btnEpisodes);
        btnLocations = findViewById(R.id.btnLocations);

        btnCharacter.setOnClickListener(this);
        btnEpisodes.setOnClickListener(this);
        btnLocations.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCharacter:
                Intent intentCharacter = new Intent(this, MainActivity.class);
                startActivity(intentCharacter);
                break;
            case R.id.btnEpisodes:
                Intent intentEpisode = new Intent(this, EpisodesActivity.class);
                startActivity(intentEpisode);
                break;
            case R.id.btnLocations:

        }
    }
}