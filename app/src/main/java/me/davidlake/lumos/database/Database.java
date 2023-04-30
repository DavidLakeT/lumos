package me.davidlake.lumos.database;

import androidx.room.RoomDatabase;

import me.davidlake.lumos.dao.AsteroidDAO;
import me.davidlake.lumos.dao.UserDAO;
import me.davidlake.lumos.model.asteroid.Asteroid;
import me.davidlake.lumos.model.user.User;

@androidx.room.Database(entities = {Asteroid.class, User.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract AsteroidDAO asteroidDao();
    public abstract UserDAO userDao();
}
