package me.davidlake.lumos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Asteroid {
    @SerializedName("links")
    @Expose
    private Links links;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("neo_reference_id")
    @Expose
    private String neoReferenceId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("nasa_jpl_url")
    @Expose
    private String nasaJplUrl;

    @SerializedName("absolute_magnitude_h")
    @Expose
    private double absoluteMagnitudeH;

    @SerializedName("estimated_diameter")
    @Expose
    private EstimatedDiameter estimatedDiameter;

    @SerializedName("is_potentially_hazardous_asteroid")
    @Expose
    private boolean isPotentiallyHazardousAsteroid;

    @SerializedName("close_approach_data")
    @Expose
    private List<CloseApproachData> closeApproachData;

    @SerializedName("is_sentry_object")
    @Expose
    private boolean isSentryObject;
}

class Links {
    @SerializedName("self")
    @Expose
    private String self;
}
class EstimatedDiameter {
    @SerializedName("kilometers")
    @Expose
    private Diameter kilometers;

    @SerializedName("meters")
    @Expose
    private Diameter meters;

    @SerializedName("miles")
    @Expose
    private Diameter miles;

    @SerializedName("feet")
    @Expose
    private Diameter feet;
}

class Diameter {
    @SerializedName("estimated_diameter_min")
    @Expose
    private double estimatedDiameterMin;

    @SerializedName("estimated_diameter_max")
    @Expose
    private double estimatedDiameterMax;
}

class CloseApproachData {
    @SerializedName("close_approach_date")
    @Expose
    private String closeApproachDate;

    @SerializedName("close_approach_date_full")
    @Expose
    private String closeApproachDateFull;

    @SerializedName("epoch_date_close_approach")
    @Expose
    private long epochDateCloseApproach;

    @SerializedName("relative_velocity")
    @Expose
    private RelativeVelocity relativeVelocity;

    @SerializedName("miss_distance")
    @Expose
    private MissDistance missDistance;

    @SerializedName("orbiting_body")
    @Expose
    private String orbitingBody;
}

class RelativeVelocity {
    @SerializedName("kilometers_per_second")
    @Expose
    private String kilometers_per_second;

    @SerializedName("kilometers_per_hour")
    @Expose
    private String kilometers_per_hour;

    @SerializedName("miles_per_hour")
    @Expose
    private String miles_per_hour;
}

class MissDistance {
    @SerializedName("astronomical")
    @Expose
    private String astronomical;

    @SerializedName("lunar")
    @Expose
    private String lunar;

    @SerializedName("kilometers")
    @Expose
    private String kilometers;

    @SerializedName("miles")
    @Expose
    private String miles;
}
