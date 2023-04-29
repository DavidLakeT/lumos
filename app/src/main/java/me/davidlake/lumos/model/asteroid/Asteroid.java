package me.davidlake.lumos.model.asteroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Entity(tableName = "asteroids")
public final class Asteroid {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("links")
    @Expose
    private Links links;

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

    @Entity(tableName = "miss_distances", foreignKeys = @ForeignKey(entity = Asteroid.class, parentColumns = "id", childColumns = "id"))
    public static final class MissDistance {
        @PrimaryKey(autoGenerate = true)
        public int id;

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

    @Entity(tableName = "close_approach_data", foreignKeys = @ForeignKey(entity = Asteroid.class, parentColumns = "id", childColumns = "id"))
    public static final class CloseApproachData {
        @PrimaryKey(autoGenerate = true)
        public int id;

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

        @Entity(tableName = "relative_velocity", foreignKeys = @ForeignKey(entity = CloseApproachData.class, parentColumns = "id", childColumns = "id"))
        public static final class RelativeVelocity {
            @PrimaryKey(autoGenerate = true)
            public int id;

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

    @Entity(tableName = "estimated_diameter", foreignKeys = @ForeignKey(entity = Asteroid.class, parentColumns = "id", childColumns = "id"))
    public static final class EstimatedDiameter {
        @PrimaryKey(autoGenerate = true)
        public int id;

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

        @Entity(tableName = "diameter_unit", foreignKeys = @ForeignKey(entity = EstimatedDiameter.class, parentColumns = "id", childColumns = "id"))
        public static final class Diameter {
            @PrimaryKey(autoGenerate = true)
            public int id;

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
}