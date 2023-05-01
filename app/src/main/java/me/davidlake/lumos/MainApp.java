package me.davidlake.lumos;

import android.app.Application;
import androidx.room.Room;

import com.facebook.stetho.Stetho;

import me.davidlake.lumos.database.Database;
import me.davidlake.lumos.network.NeoApi;

public class MainApp extends Application {
    private Database database;
    private NeoApi neoApi;
    private int currentUserId;

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
        database = Room.databaseBuilder(this, Database.class, "database").build();
        neoApi = new NeoApi("HqdaBGHMcKg9hKjlWK6HyjrkWrw0DKgNV9R5vmA4");
    }

    public Database getDatabase() {
        return database;
    }

    public NeoApi getNeoApi() {
        return neoApi;
    }

    public int getCurrentUserId() { return currentUserId; }

    public void setCurrentUserId(int userId) { currentUserId = userId; }
}
