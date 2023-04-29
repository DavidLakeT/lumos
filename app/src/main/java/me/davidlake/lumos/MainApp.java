package me.davidlake.lumos;

import android.app.Application;

import androidx.room.Room;

import me.davidlake.lumos.database.AsteroidDatabase;

public class MainApp extends Application {
    public final AsteroidDatabase room = Room.databaseBuilder(this, AsteroidDatabase.class, "asteroids").build();
}
