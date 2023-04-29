package me.davidlake.lumos.model.asteroid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Asteroid {

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

    public Links getLinks() {
        return links;
    }

    public String getId() {
        return id;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public List<CloseApproachData> getCloseApproachData() {
        return closeApproachData;
    }

    public boolean isSentryObject() {
        return isSentryObject;
    }

    private static final class MissDistance {

        private String astronomical;
        private String lunar;
        private String kilometers;
        private String miles;

        public String getAstronomical() {
            return astronomical;
        }

        public String getLunar() {
            return lunar;
        }

        public String getKilometers() {
            return kilometers;
        }

        public String getMiles() {
            return miles;
        }
    }

    private static final class CloseApproachData {

        @SerializedName("close_approach_date")
        private String closeApproachDate;
        @SerializedName("epoch_date_close_approach")
        private long epochDateCloseApproach;
        @SerializedName("relative_velocity")
        private RelativeVelocity relativeVelocity;
        @SerializedName("miss_distance")
        private MissDistance missDistance;
        @SerializedName("orbiting_body")
        private String orbitingBody;

        public String getCloseApproachDate() {
            return closeApproachDate;
        }

        public long getEpochDateCloseApproach() {
            return epochDateCloseApproach;
        }

        public RelativeVelocity getRelativeVelocity() {
            return relativeVelocity;
        }

        public MissDistance getMissDistance() {
            return missDistance;
        }

        public String getOrbitingBody() {
            return orbitingBody;
        }
    }

    private static final class EstimatedDiameter {

        private Diameter kilometers;
        private Diameter meters;
        private Diameter miles;
        private Diameter feet;

        public Diameter getKilometers() {
            return kilometers;
        }

        public Diameter getMeters() {
            return meters;
        }

        public Diameter getMiles() {
            return miles;
        }

        public Diameter getFeet() {
            return feet;
        }

        private static final class Diameter {

            @SerializedName("estimated_diameter_min")
            private String estimatedDiameterMin;
            @SerializedName("estimated_diameter_max")
            private String estimatedDiameterMax;

            public String getEstimatedDiameterMin() {
                return estimatedDiameterMin;
            }

            public String getEstimatedDiameterMax() {
                return estimatedDiameterMax;
            }
        }
    }

    private static final class RelativeVelocity {

        @SerializedName("kilometers_per_second")
        private String kilometersPerSecond;
        @SerializedName("kilometers_per_hour")
        private String kilometersPerHour;
        @SerializedName("miles_per_hour")
        private String milesPerHour;

        public String getKilometersPerSecond() { return kilometersPerSecond; }

        public String getKilometersPerHour() { return kilometersPerHour; }

        public String getMilesPerHour() { return milesPerHour; }
    }
}