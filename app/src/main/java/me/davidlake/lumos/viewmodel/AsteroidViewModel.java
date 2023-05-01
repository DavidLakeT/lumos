package me.davidlake.lumos.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.List;

import me.davidlake.lumos.MainApp;
import me.davidlake.lumos.database.Database;
import me.davidlake.lumos.model.asteroid.Asteroid;
import me.davidlake.lumos.model.asteroid.AsteroidFeed;
import me.davidlake.lumos.network.NeoApi;

public class AsteroidViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Asteroid>> asteroidList = new MutableLiveData<>();
    private final NeoApi neoApi;
    private final MainApp app;
    private final Database database;

    public AsteroidViewModel(Application application) {
        super(application);
        app = (MainApp) application;
        neoApi = app.getNeoApi();
        database = app.getDatabase();
    }

    public LiveData<List<Asteroid>> getAsteroidList() {
        return asteroidList;
    }

    public void loadAsteroids(String startDate, String endDate) {
        new Thread(() -> {
            try {
                AsteroidFeed asteroidFeed = neoApi.getAsteroidFeed(startDate, endDate);
                List<Asteroid> asteroidList = asteroidFeed.getAsteroids().get(startDate);
                assert asteroidList != null;
                for(Asteroid asteroid : asteroidList) {
                    if(asteroid.getUserId() == 0) {
                        asteroid.setUserId(app.getCurrentUserId());
                    }
                    database.asteroidDao().insert(asteroid);
                }
                this.asteroidList.postValue(asteroidList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public String getDate() {
        return app.getProperties().getProperty("INFO_DATE");
    }
}
