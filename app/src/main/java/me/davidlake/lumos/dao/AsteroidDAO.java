package me.davidlake.lumos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import me.davidlake.lumos.model.asteroid.Asteroid;
import me.davidlake.lumos.model.user.User;

@Dao
public interface AsteroidDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Asteroid... asteroids);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Asteroid asteroid);

    @Query("DELETE FROM asteroids")
    void deleteAll();

    @Delete
    void delete(Asteroid asteroid);

    @Query("SELECT * FROM asteroids")
    List<User> getAll();

    @Query("SELECT * FROM asteroids WHERE id = :id")
    Asteroid getById(String id);
}