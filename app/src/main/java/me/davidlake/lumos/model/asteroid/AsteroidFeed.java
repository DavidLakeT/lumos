package me.davidlake.lumos.model.asteroid;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class AsteroidFeed {

    private Links links;
    @SerializedName("element_count")
    private int elementCount;
    @SerializedName("near_earth_objects")
    private Map<String, List<Asteroid>> asteroids;

    public Links getLinks() { return this.links; }
    public int getElementCount() { return this.elementCount; }
    public Map<String, List<Asteroid>> getAsteroids() { return this.asteroids; }
}