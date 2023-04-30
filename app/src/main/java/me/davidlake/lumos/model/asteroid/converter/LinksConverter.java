package me.davidlake.lumos.model.asteroid.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;

import me.davidlake.lumos.model.asteroid.Links;

public class LinksConverter {
    private static final Gson gson = new Gson();

    @TypeConverter
    public static Links fromString(String value) {
        return gson.fromJson(value, Links.class);
    }

    @TypeConverter
    public static String fromLinks(Links links) {
        return gson.toJson(links);
    }
}
