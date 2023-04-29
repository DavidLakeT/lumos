package me.davidlake.lumos.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import me.davidlake.lumos.dao.AsteroidDAO;
import me.davidlake.lumos.model.asteroid.Asteroid;

@Database(entities = {Asteroid.class}, version = 1)
public abstract class AsteroidDatabase extends RoomDatabase {
    public abstract AsteroidDAO asteroidDao();
}
