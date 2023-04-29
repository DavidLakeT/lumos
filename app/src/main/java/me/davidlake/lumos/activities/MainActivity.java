package me.davidlake.lumos.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import me.davidlake.lumos.MainApp;
import me.davidlake.lumos.R;
import me.davidlake.lumos.model.asteroid.Asteroid;
import me.davidlake.lumos.model.asteroid.AsteroidFeed;
import me.davidlake.lumos.network.NeoApi;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasa);

        NeoApi neoApi = new NeoApi("HqdaBGHMcKg9hKjlWK6HyjrkWrw0DKgNV9R5vmA4");

        MainApp app = (MainApp) getApplicationContext();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AsteroidFeed asteroidFeed = neoApi.getAsteroidFeed("2023-04-29", "2023-05-06");
                    for (Asteroid asteroid : asteroidFeed.getAsteroids().get("2023-04-29")) {
                        Log.d("DAVID-DEBUG", "ID A REGISTRAR: " + asteroid.getId());
                        app.room.asteroidDao().insert(asteroid);
                        Log.d("DAVID-DEBUG", "ID REGISTRADO: " + app.room.asteroidDao().getById(asteroid.getId()).getId());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AsteroidFeed asteroidFeed = neoApi.getAsteroidFeed("2023-04-29", "2023-05-06");
                    List<Asteroid> asteroids = asteroidFeed.getAsteroids().get("2023-04-29");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}