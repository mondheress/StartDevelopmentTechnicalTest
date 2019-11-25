package com.example.startdevelopmenttechnicaltest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.startdevelopmenttechnicaltest.R;

import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.Diameter;
import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.PlanetName;
import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.Population;
import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.climate;
import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.orbital;
import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.rotation;
import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.surface;
import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.terrain;
import static com.example.startdevelopmenttechnicaltest.activity.StarWarsActivity.gravity;

public class StarWarsDetailActivity extends AppCompatActivity {

    private TextView textViewPlanetName;
    private TextView textViewPopulation;
    private TextView textViewDiameter;
    private TextView textViewRotation;
    private TextView textViewOrbital;
    private TextView textViewClimate;
    private TextView textViewGravity;
    private TextView textViewTerrain;
    private TextView textViewSurface;
    private ImageButton previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra(PlanetName);
        String population = intent.getStringExtra(Population);
        String diameter = intent.getStringExtra(Diameter);
        String climat = intent.getStringExtra(climate);
        String planetrotation = intent.getStringExtra(rotation);
        String planetorbital = intent.getStringExtra(orbital);
        String planetGravity = intent.getStringExtra(gravity);
        String planetTerrain = intent.getStringExtra(terrain);
        String planetSurface = intent.getStringExtra(surface);


        textViewPlanetName = findViewById(R.id.activity_star_wars_detail_name);
        textViewPopulation = findViewById(R.id.activity_star_wars_detail_population);
        textViewDiameter = findViewById(R.id.activity_star_wars_detail_diameter);
        textViewRotation = findViewById(R.id.activity_star_wars_detail_rotation);
        textViewOrbital = findViewById(R.id.activity_star_wars_detail_orbital);
        textViewClimate = findViewById(R.id.activity_star_wars_detail_climate);
        textViewGravity = findViewById(R.id.activity_star_wars_detail_gravity);
        textViewTerrain = findViewById(R.id.activity_star_wars_detail_terrain);
        textViewSurface = findViewById(R.id.activity_star_wars_detail_surface);
        previous = findViewById(R.id.activity_star_wars_detail_back);

        textViewPlanetName.setText(name);
        textViewPopulation.setText(getString(R.string.starwars_detail_population)+population);
        textViewDiameter.setText(getString(R.string.starwars_detail_diameter)+diameter);
        textViewRotation.setText(getString(R.string.starwars_detail_rotation)+planetrotation);
        textViewOrbital.setText(getString(R.string.starwars_detail_orbital)+planetorbital);
        textViewClimate.setText(getString(R.string.starwars_detail_climate)+climat);
        textViewGravity.setText(getString(R.string.starwars_detail_gravity)+planetGravity);
        textViewTerrain.setText(getString(R.string.starwars_detail_terrain)+planetTerrain);
        textViewSurface.setText(getString(R.string.starwars_detail_surface)+planetSurface);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StarWarsDetailActivity.this, StarWarsActivity.class));

            }
        });

    }
}
