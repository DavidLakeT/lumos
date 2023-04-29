package me.davidlake.lumos.database;

import androidx.room.Database;

import me.davidlake.lumos.dao.AsteroidDAO;
import me.davidlake.lumos.model.asteroid.Asteroid;

@Database(entities = {Asteroid.class}, version = 1)
public abstract class AsteroidDatabase {
    public abstract AsteroidDAO asteroidDao();
}
