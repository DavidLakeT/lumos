package me.davidlake.lumos.model.user;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

import me.davidlake.lumos.model.asteroid.Asteroid;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String createdAt;

    @Ignore
    private List<Asteroid> asteroids;

    // CONSTRUCTOR

    public User(
            int id,
            String email,
            String password,
            String firstName,
            String lastName,
            String createdAt
    ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }

    // GETTERS

    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCreatedAt() { return createdAt; }
    public List<Asteroid> getAsteroids() { return asteroids; }

    // SETTERS

    public void setId(int id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public void setAsteroids(List<Asteroid> asteroids) { this.asteroids = asteroids; }
}
