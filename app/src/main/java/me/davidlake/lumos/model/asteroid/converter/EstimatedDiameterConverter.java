package me.davidlake.lumos.model.asteroid.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import me.davidlake.lumos.model.asteroid.Asteroid;

public class EstimatedDiameterConverter {
    @TypeConverter
    public static Asteroid.EstimatedDiameter fromString(String value) {
        Type type = new TypeToken<Asteroid.EstimatedDiameter>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromEstimatedDiameter(Asteroid.EstimatedDiameter estimatedDiameter) {
        Gson gson = new Gson();
        return gson.toJson(estimatedDiameter);
    }
}
