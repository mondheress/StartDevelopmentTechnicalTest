package com.example.startdevelopmenttechnicaltest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.startdevelopmenttechnicaltest.R;
import com.example.startdevelopmenttechnicaltest.model.StarWarsItem;

import java.util.ArrayList;


public class StarWarsAdapter extends RecyclerView.Adapter<StarWarsAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<StarWarsItem> mRestaurantItemList;
    private OnItemClickListener mListener;

    public StarWarsAdapter(Context context, ArrayList<StarWarsItem> exampleList) {
        mContext = context;
        mRestaurantItemList = exampleList;
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_star_wars_items, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        StarWarsItem currentItem = mRestaurantItemList.get(position);

        String planetName = currentItem.getmPlanetName();
        String population = currentItem.getmPopulation();
        String diameter = currentItem.getmDiameter();

        holder.planetName.setText(planetName);
        holder.population.setText(mContext.getString(R.string.starwars_detail_population) + population);
        holder.diameter.setText(mContext.getString(R.string.starwars_detail_diameter) + diameter);
    }

    @Override
    public int getItemCount() {
        return mRestaurantItemList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        private TextView planetName;
        private TextView population;
        private TextView diameter;
        private ImageButton detailButton;


        private ExampleViewHolder(View itemView) {
            super(itemView);
            planetName = itemView.findViewById(R.id.activity_star_wars_planet_name);
            population = itemView.findViewById(R.id.activity_star_wars_planet_population);
            diameter = itemView.findViewById(R.id.activity_star_wars_planet_diameter);
            detailButton = itemView.findViewById(R.id.activity_star_wars_items_button);
            detailButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}