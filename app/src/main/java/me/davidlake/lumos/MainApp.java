package me.davidlake.lumos;

import android.app.Application;

import androidx.room.Room;

import com.facebook.stetho.Stetho;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import me.davidlake.lumos.database.Database;
import me.davidlake.lumos.network.NeoApi;

public class MainApp extends Application {
    private Database database;
    private NeoApi neoApi;
    private int currentUserId;
    private Properties properties;

    @Override
    public void onCreate() {
        super.onCreate();

        properties = new Properties();
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.config);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String apiKey = properties.getProperty("api_key");


        Stetho.initializeWithDefaults(this);
        database = Room.databaseBuilder(this, Database.class, "database").build();
        neoApi = new NeoApi(properties.getProperty("API_KEY"));
    }

    public Database getDatabase() {
        return database;
    }
    public NeoApi getNeoApi() {
        return neoApi;
    }
    public Properties getProperties() { return properties; }
    public int getCurrentUserId() { return currentUserId; }
    public void setCurrentUserId(int userId) { currentUserId = userId; }
}
