package me.davidlake.lumos.model.utils;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import me.davidlake.lumos.model.asteroid.Asteroid;
import me.davidlake.lumos.model.user.User;

public class UserAsteroids {
    @Embedded
    public User user;

    @Relation(parentColumn = "id", entityColumn = "user_id")
    public List<Asteroid> asteroids;
}