package me.davidlake.lumos;

import android.app.Application;

import androidx.room.Room;

import me.davidlake.lumos.database.AsteroidDatabase;
import me.davidlake.lumos.network.NeoApi;

public class MainApp extends Application {
    private AsteroidDatabase room;
    private NeoApi neoApi;

    @Override
    public void onCreate() {
        super.onCreate();

        room = Room.databaseBuilder(this, AsteroidDatabase.class, "asteroids").build();
        neoApi = new NeoApi("HqdaBGHMcKg9hKjlWK6HyjrkWrw0DKgNV9R5vmA4");
    }

    public AsteroidDatabase getDatabase() {
        return room;
    }

    public NeoApi getNeoApi() {
        return neoApi;
    }
}
