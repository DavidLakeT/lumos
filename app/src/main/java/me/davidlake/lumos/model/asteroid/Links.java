package me.davidlake.lumos.model.asteroid;

import androidx.room.Entity;

@Entity
public final class Links {
    private String next;
    private String prev;
    private String self;

    public String getNext() { return next; }

    public String getPrev() { return prev; }

    public String getSelf() { return self; }
}
