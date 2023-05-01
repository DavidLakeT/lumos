package me.davidlake.lumos.model.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import me.davidlake.lumos.R;
import me.davidlake.lumos.model.asteroid.Asteroid;

public class ListAdapter extends ArrayAdapter<Asteroid> {

    public ListAdapter(Context context, List<Asteroid> asteroidArrayList){
        super(context, R.layout.asteroid_list, asteroidArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Asteroid asteroid = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.asteroid_list,parent,false);
        }

        TextView asteroidName = convertView.findViewById(R.id.asteroid_name);
        TextView asteroidId = convertView.findViewById(R.id.asteroid_id);
        TextView asteroidEstimatedDiameter = convertView.findViewById(R.id.asteroid_diameter);
        TextView asteroidIsDangerous = convertView.findViewById(R.id.asteroid_is_dangerous);

        asteroidName.setText("Name: " + asteroid.getName());
        asteroidId.setText("ID: " + asteroid.getId());
        asteroidEstimatedDiameter.setText("Max diameter (km): " + asteroid.getEstimatedDiameter().getKilometers().getEstimatedDiameterMax());
        asteroidIsDangerous.setText("Is dangerous: " + String.valueOf(asteroid.isPotentiallyHazardousAsteroid()));

        return convertView;
    }
}