package me.davidlake.lumos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import me.davidlake.lumos.R;
import me.davidlake.lumos.model.user.User;
import me.davidlake.lumos.model.utils.ListAdapter;
import me.davidlake.lumos.viewmodel.AsteroidViewModel;
import me.davidlake.lumos.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private AsteroidViewModel asteroidViewModel;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Loading asteroid info...", Toast.LENGTH_SHORT).show();

        asteroidViewModel = new ViewModelProvider(this).get(AsteroidViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.loadUser(userViewModel.getCurrentUserId());
        asteroidViewModel.loadAsteroids(asteroidViewModel.getDate(), asteroidViewModel.getDate());

        ListView listView = findViewById(R.id.listview);
        TextView welcomeTextView = findViewById(R.id.welcome_text_view);
        userViewModel.loadUser(userViewModel.getCurrentUserId());

        userViewModel.getUserInfo().observe(this, userInfo -> {
            welcomeTextView.setText("Welcome\n" + userInfo.getFirstName() + " " + userInfo.getLastName());
        });


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
                intent.putExtra("asteroid_user_id", String.valueOf(asteroidList.get(position).getUserId()));

                startActivity(intent);
            });
        });
    }
}