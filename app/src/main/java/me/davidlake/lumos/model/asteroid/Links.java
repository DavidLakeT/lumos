package me.davidlake.lumos.model.asteroid;

import androidx.room.Entity;
import androidx.room.TypeConverter;

import com.google.gson.Gson;

@Entity
public final class Links {
    private String next;
    private String prev;
    private String self;

    public String getNext() { return next; }

    public String getPrev() { return prev; }

    public String getSelf() { return self; }
}
