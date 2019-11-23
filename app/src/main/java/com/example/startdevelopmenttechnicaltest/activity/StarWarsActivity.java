package com.example.startdevelopmenttechnicaltest.activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.startdevelopmenttechnicaltest.R;
import com.example.startdevelopmenttechnicaltest.adapter.StarWarsAdapter;
import com.example.startdevelopmenttechnicaltest.model.StarWarsItem;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StarWarsActivity extends AppCompatActivity implements StarWarsAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private StarWarsAdapter mPlanetListAdapter;
    private ArrayList<StarWarsItem> mPlanetList;
    private RequestQueue mRequestQueue;
    public static final String PlanetName = "PlanetName";
    public static final String Population = "Population";
    public static final String Diameter = "Diameter";
    public static final String climate = "Climate";
    public static final String rotation = "Rotation";
    public static final String orbital = "Orbital";
    public static final String gravity = "Gravity";
    public static final String terrain = "Terrain";
    public static final String surface = "Surface";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPlanetList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://swapi.co/api/planets";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String planetName = hit.getString("name");
                                String population = hit.getString("population");
                                String diameter = hit.getString("diameter");
                                String climate = hit.getString("climate");
                                String rotation_period = hit.getString("rotation_period");
                                String orbital_period = hit.getString("orbital_period");
                                String gravity = hit.getString("gravity");
                                String terrain = hit.getString("terrain");
                                String surface_water = hit.getString("surface_water");


                                mPlanetList.add(new StarWarsItem(planetName, population, diameter,climate,rotation_period,orbital_period,gravity,terrain,surface_water));
                            }

                            mPlanetListAdapter = new StarWarsAdapter(StarWarsActivity.this, mPlanetList);
                            mRecyclerView.setAdapter(mPlanetListAdapter);
                            mPlanetListAdapter.setOnItemClickListener(StarWarsActivity.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy( 50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, StarWarsDetailActivity.class);
        StarWarsItem clickedItem = mPlanetList.get(position);

        detailIntent.putExtra(PlanetName, clickedItem.getmPlanetName());
        detailIntent.putExtra(Population, clickedItem.getmPopulation());
        detailIntent.putExtra(Diameter, clickedItem.getmDiameter());
        detailIntent.putExtra(climate, clickedItem.getmClimate());
        detailIntent.putExtra(orbital, clickedItem.getmOrbital());
        detailIntent.putExtra(rotation, clickedItem.getmRotation());
        detailIntent.putExtra(gravity, clickedItem.getmGravity());
        detailIntent.putExtra(terrain, clickedItem.getmTerrain());
        detailIntent.putExtra(surface, clickedItem.getmSurface());
        startActivity(detailIntent);
    }
}