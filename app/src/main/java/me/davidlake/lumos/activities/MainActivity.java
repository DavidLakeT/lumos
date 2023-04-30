package me.davidlake.lumos.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import me.davidlake.lumos.MainApp;
import me.davidlake.lumos.R;
import me.davidlake.lumos.database.Database;
import me.davidlake.lumos.model.asteroid.Asteroid;
import me.davidlake.lumos.model.asteroid.AsteroidFeed;
import me.davidlake.lumos.network.NeoApi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MainApp app = (MainApp) getApplication();
        NeoApi neoApi = app.getNeoApi();
        Database database = app.getDatabase();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> new Thread(() -> {
            try {
                AsteroidFeed asteroidFeed = neoApi.getAsteroidFeed("2023-04-29", "2023-05-06");
                List<Asteroid> asteroidList = asteroidFeed.getAsteroids().get("2023-04-29");
                if (asteroidList != null) {
                    for (Asteroid asteroid : asteroidList) {
                        database.asteroidDao().insert(asteroid);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start());

    }
}