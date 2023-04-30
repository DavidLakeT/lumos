package me.davidlake.lumos.model.asteroid.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import me.davidlake.lumos.model.asteroid.Asteroid;

public class CloseApproachDataConverter {
    @TypeConverter
    public static List<Asteroid.CloseApproachData> fromString(String value) {
        Type type = new TypeToken<List<Asteroid.CloseApproachData>>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromCloseApproachDataList(List<Asteroid.CloseApproachData> closeApproachDataList) {
        Gson gson = new Gson();
        return gson.toJson(closeApproachDataList);
    }
}
