package me.davidlake.lumos.model.asteroid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

import me.davidlake.lumos.model.asteroid.converter.CloseApproachDataConverter;
import me.davidlake.lumos.model.asteroid.converter.EstimatedDiameterConverter;
import me.davidlake.lumos.model.asteroid.converter.LinksConverter;

@Entity(tableName = "asteroids")
@TypeConverters({EstimatedDiameterConverter.class, CloseApproachDataConverter.class, LinksConverter.class})
public final class Asteroid {

    public Asteroid (
            @NonNull String id,
            Links links,
            String neoReferenceId,
            String name,
            String nasaJplUrl,
            double absoluteMagnitudeH,
            EstimatedDiameter estimatedDiameter,
            boolean isPotentiallyHazardousAsteroid,
            List<CloseApproachData> closeApproachData,
            boolean isSentryObject
    ) {
        this.id = id;
        this.links = links;
        this.neoReferenceId = neoReferenceId;
        this.name = name;
        this.nasaJplUrl = nasaJplUrl;
        this.absoluteMagnitudeH = absoluteMagnitudeH;
        this.estimatedDiameter = estimatedDiameter;
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
        this.closeApproachData = closeApproachData;
        this.isSentryObject = isSentryObject;
    }

    @PrimaryKey
    @NonNull
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

    // GETTERS

    @NonNull
    public String getId() {
        return id;
    }
    public Links getLinks() {
        return links;
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

    // SETTERS

    public void setId(@NonNull String id) { this.id = id; }
    public void setLinks(Links links) { this.links = links; }
    public void setNeoReferenceId(String neoReferenceId) { this.neoReferenceId = neoReferenceId; }
    public void setName(String name) { this.name = name; }
    public void setNasaJplUrl(String nasaJplUrl) { this.nasaJplUrl = nasaJplUrl; }
    public void setAbsoluteMagnitudeH(double absoluteMagnitudeH) { this.absoluteMagnitudeH = absoluteMagnitudeH; }
    public void setEstimatedDiameter(EstimatedDiameter estimatedDiameter) { this.estimatedDiameter = estimatedDiameter; }
    public void setPotentiallyHazardousAsteroid(boolean isPotentiallyHazardousAsteroid) { this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid; }
    public void setCloseApproachData(List<CloseApproachData> closeApproachData) { this.closeApproachData = closeApproachData; }
    public void setSentryObject(boolean isSentryObject) { this.isSentryObject = isSentryObject; }

    @Entity(tableName = "miss_distances", foreignKeys = @ForeignKey(entity = Asteroid.class, parentColumns = "id", childColumns = "id"))
    public static final class MissDistance {

        public MissDistance(
                @NonNull String id,
                String astronomical,
                String lunar,
                String kilometers,
                String miles
        ) {
            this.id = id;
            this.astronomical = astronomical;
            this.lunar = lunar;
            this.kilometers = kilometers;
            this.miles = miles;
        }

        @PrimaryKey(autoGenerate = true)
        @NonNull
        public String id;

        private String astronomical;

        private String lunar;

        private String kilometers;

        private String miles;

        // GETTERS

        @NonNull
        public String getId() { return id; }
        public String getAstronomical() { return astronomical; }
        public String getLunar() { return lunar; }
        public String getKilometers() { return kilometers; }
        public String getMiles() { return miles; }

        // SETTERS

        public void setId(@NonNull String id) { this.id = id; }
        public void setAstronomical(String astronomical) { this.astronomical = astronomical; }
        public void setLunar(String lunar) { this.lunar = lunar; }
        public void setKilometers(String kilometers) { this.kilometers = kilometers; }
        public void setMiles(String miles) { this.miles = miles; }
    }

    @Entity(tableName = "close_approach_data", foreignKeys = @ForeignKey(entity = Asteroid.class, parentColumns = "id", childColumns = "id"))
    public static final class CloseApproachData {

        public CloseApproachData(
                @NonNull String id,
                String closeApproachDate,
                long epochDateCloseApproach,
                RelativeVelocity relativeVelocity,
                MissDistance missDistance,
                String orbitingBody
        ) {
            this.id = id;
            this.closeApproachDate = closeApproachDate;
            this.epochDateCloseApproach = epochDateCloseApproach;
            this.relativeVelocity = relativeVelocity;
            this.missDistance = missDistance;
            this.orbitingBody = orbitingBody;
        }

        @PrimaryKey(autoGenerate = true)
        @NonNull
        public String id;

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

        // GETTERS

        @NonNull
        public String getId() { return id; }
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

        // SETTERS

        public void setId(@NonNull String id) { this.id = id; }
        public void setCloseApproachDate(String closeApproachDate) { this.closeApproachDate = closeApproachDate; }
        public void setEpochDateCloseApproach(long epochDateCloseApproach) { this.epochDateCloseApproach = epochDateCloseApproach; }
        public void setRelativeVelocity(RelativeVelocity relativeVelocity) { this.relativeVelocity = relativeVelocity; }
        public void setMissDistance(MissDistance missDistance) { this.missDistance = missDistance; }
        public void setOrbitingBody(String orbitingBody) { this.orbitingBody = orbitingBody; }

        @Entity(tableName = "relative_velocity", foreignKeys = @ForeignKey(entity = CloseApproachData.class, parentColumns = "id", childColumns = "id"))
        public static final class RelativeVelocity {

            public RelativeVelocity(
                    @NonNull String id,
                    String kilometersPerSecond,
                    String kilometersPerHour,
                    String milesPerHour
            ) {
                this.id = id;
                this.kilometersPerSecond = kilometersPerSecond;
                this.kilometersPerHour = kilometersPerHour;
                this.milesPerHour = milesPerHour;
            }

            @PrimaryKey(autoGenerate = true)
            @NonNull
            public String id;

            @SerializedName("kilometers_per_second")
            private String kilometersPerSecond;
            @SerializedName("kilometers_per_hour")
            private String kilometersPerHour;
            @SerializedName("miles_per_hour")
            private String milesPerHour;

            // GETTERS

            @NonNull
            public String getId() { return id; }
            public String getKilometersPerSecond() { return kilometersPerSecond; }
            public String getKilometersPerHour() { return kilometersPerHour; }
            public String getMilesPerHour() { return milesPerHour; }

            // SETTERS

            public void setId(@NonNull String id) { this.id = id; }
            public void setKilometersPerSecond(String kilometersPerSecond) { this.kilometersPerSecond = kilometersPerSecond; }
            public void setKilometersPerHour(String kilometersPerHour) { this.kilometersPerHour = kilometersPerHour; }
            public void setMilesPerHour(String milesPerHour) { this.milesPerHour = milesPerHour; }
        }
    }

    @Entity(tableName = "estimated_diameter", foreignKeys = @ForeignKey(entity = Asteroid.class, parentColumns = "id", childColumns = "id"))
    public static final class EstimatedDiameter {

        public EstimatedDiameter(
                @NonNull String id,
                Diameter kilometers,
                Diameter meters,
                Diameter miles,
                Diameter feet
        ) {
            this.id = id;
            this.kilometers = kilometers;
            this.meters = meters;
            this.miles = miles;
            this.feet = feet;
        }

        @PrimaryKey(autoGenerate = true)
        @NonNull
        public String id;

        private Diameter kilometers;
        private Diameter meters;
        private Diameter miles;
        private Diameter feet;

        // GETTERS

        @NonNull
        public String getId() { return id; }
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

        // SETTERS

        public void setId(@NonNull String id) { this.id = id; }
        public void setKilometers(Diameter kilometers) { this.kilometers = kilometers; }
        public void setMeters(Diameter meters) { this.meters = meters; }
        public void setMiles(Diameter miles) { this.miles = miles; }
        public void setFeet(Diameter feet) { this.feet = feet; }

        @Entity(tableName = "diameter_unit", foreignKeys = @ForeignKey(entity = EstimatedDiameter.class, parentColumns = "id", childColumns = "id"))
        public static final class Diameter {

            public Diameter(
                    String id,
                    String estimatedDiameterMin,
                    String estimatedDiameterMax
            ) {
                this.id = id;
                this.estimatedDiameterMin = estimatedDiameterMin;
                this.estimatedDiameterMax = estimatedDiameterMax;
            }

            @PrimaryKey(autoGenerate = true)
            @NonNull
            public String id;

            @SerializedName("estimated_diameter_min")
            private String estimatedDiameterMin;
            @SerializedName("estimated_diameter_max")
            private String estimatedDiameterMax;

            // GETTERS

            @NonNull
            public String getId() { return id; }
            public String getEstimatedDiameterMin() {
                return estimatedDiameterMin;
            }
            public String getEstimatedDiameterMax() {
                return estimatedDiameterMax;
            }

            // SETTERS

            public void setId(@NonNull String id) { this.id = id; }
            public void setEstimatedDiameterMin(String estimatedDiameterMin) { this.estimatedDiameterMin = estimatedDiameterMin; }
            public void setEstimatedDiameterMax(String estimatedDiameterMax) { this.estimatedDiameterMax = estimatedDiameterMax; }
        }
    }
}