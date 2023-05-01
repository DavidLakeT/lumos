package me.davidlake.lumos.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import me.davidlake.lumos.MainApp;
import me.davidlake.lumos.database.Database;
import me.davidlake.lumos.model.user.User;

public class UserViewModel extends AndroidViewModel {
    private final MutableLiveData<User> userInfo = new MutableLiveData<>();
    private final Database database;
    private final MainApp app;

    public UserViewModel(Application application) {
        super(application);
        app = (MainApp) application;
        database = app.getDatabase();
    }

    public void setCurrentUserId(int id) { app.setCurrentUserId(id); }

    public LiveData<User> checkUser(String email, String password) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();

        new Thread(() -> {
            User user = database.userDao().readAllData(email, password);
            userLiveData.postValue(user);
        }).start();

        return userLiveData;
    }

    public LiveData<User> registerUser(String email, String password, String firstName, String lastName, String identificationId) {
        MutableLiveData<User> userRegisteredLiveData = new MutableLiveData<>();

        new Thread(() -> {
            User existingUser = database.userDao().getUserByEmail(email);
            if (existingUser != null) {
                userRegisteredLiveData.postValue(null);
            } else {
                User user = new User(email, password, firstName, lastName, identificationId);
                database.userDao().insert(user);
                userRegisteredLiveData.postValue(database.userDao().getUserByEmail(email));
            }
        }).start();

        return userRegisteredLiveData;
    }
}