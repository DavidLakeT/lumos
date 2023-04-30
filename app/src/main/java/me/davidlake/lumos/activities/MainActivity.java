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

        Log.d("DAVID-DEBUG", "VISTA CARGADA CORRECTAMENTE");

        MainApp app = (MainApp) getApplication();
        NeoApi neoApi = app.getNeoApi();
        AsteroidDatabase room = app.getDatabase();

        Log.d("DAVID-DEBUG", "CONTEXTO CARGADO CORRECTAMENTE");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AsteroidFeed asteroidFeed = neoApi.getAsteroidFeed("2023-04-29", "2023-05-06");
                    Log.d("DAVID-DEBUG", "YA DEBERÍA EMPEZAR A IMPRIMIR...");
                    for (Asteroid asteroid : asteroidFeed.getAsteroids().get("2023-04-29")) {
                        Log.d("DAVID-DEBUG", "ID A REGISTRAR: " + asteroid.getId());
                        room.asteroidDao().insert(asteroid);
                        Log.d("DAVID-DEBUG", "ID REGISTRADO: " + room.asteroidDao().getById(asteroid.getId()).getId());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}