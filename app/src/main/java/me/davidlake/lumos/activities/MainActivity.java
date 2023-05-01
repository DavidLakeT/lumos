package me.davidlake.lumos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import me.davidlake.lumos.R;
import me.davidlake.lumos.model.utils.ListAdapter;
import me.davidlake.lumos.viewmodel.AsteroidViewModel;

public class MainActivity extends AppCompatActivity {
    private AsteroidViewModel asteroidViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Loading asteroid info...", Toast.LENGTH_SHORT).show();

        asteroidViewModel = new ViewModelProvider(this).get(AsteroidViewModel.class);

        ListView listView = findViewById(R.id.listview);

        asteroidViewModel.loadAsteroids("2023-04-28", "2023-04-28");

        asteroidViewModel.getAsteroidList().observe(this, asteroidList -> {
            ListAdapter listAdapter = new ListAdapter(MainActivity.this, asteroidList);
            listView.setAdapter(listAdapter);
            listView.setClickable(true);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                Intent intent = new Intent(MainActivity.this, AsteroidActivity.class);

                intent.putExtra("asteroid_name", asteroidList.get(position).getName());
                intent.putExtra("asteroid_id", asteroidList.get(position).getId());
                intent.putExtra("asteroid_estimated_diameter", asteroidList.get(position).getEstimatedDiameter().getKilometers().getEstimatedDiameterMax());
                intent.putExtra("asteroid_is_dangerous", String.valueOf(asteroidList.get(position).isPotentiallyHazardousAsteroid()));
                intent.putExtra("asteroid_is_sentry_object", String.valueOf(asteroidList.get(position).isSentryObject()));
                intent.putExtra("asteroid_close_approach_date", asteroidList.get(position).getCloseApproachData().get(0).getCloseApproachDate());
                intent.putExtra("asteroid_miss_distance", asteroidList.get(position).getCloseApproachData().get(0).getMissDistance().getKilometers());

                startActivity(intent);
            });
        });
    }
}