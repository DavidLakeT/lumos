package me.davidlake.lumos.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import me.davidlake.lumos.MainApp;
import me.davidlake.lumos.R;
import me.davidlake.lumos.database.AsteroidDatabase;
import me.davidlake.lumos.model.asteroid.Asteroid;
import me.davidlake.lumos.model.asteroid.AsteroidFeed;
import me.davidlake.lumos.network.NeoApi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasa);

        MainApp app = (MainApp) getApplication();
        NeoApi neoApi = app.getNeoApi();
        AsteroidDatabase asteroidDatabase = app.getDatabase();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AsteroidFeed asteroidFeed = neoApi.getAsteroidFeed("2023-04-29", "2023-05-06");
                            for (Asteroid asteroid : asteroidFeed.getAsteroids().get("2023-04-29")) {
                                asteroidDatabase.asteroidDao().insert(asteroid);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }
}