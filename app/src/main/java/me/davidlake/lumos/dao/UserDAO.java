package me.davidlake.lumos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import me.davidlake.lumos.model.user.User;
import me.davidlake.lumos.model.utils.UserAsteroids;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("DELETE FROM users")
    void deleteAll();

    @Delete
    void delete(User user);

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE id = :id")
    User getById(int id);

    @Transaction
    @Query("SELECT * FROM users")
    List<UserAsteroids> getUsersWithAsteroids();
}