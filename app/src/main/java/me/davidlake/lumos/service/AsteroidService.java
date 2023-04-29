package me.davidlake.lumos.service;

import me.davidlake.lumos.model.asteroid.AsteroidFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AsteroidService {
    @GET("/neo/rest/v1/feed")
    Call<AsteroidFeed> feed(
            @Query("start_date") String startDate,
            @Query("end_date") String endDate,
            @Query("api_key") String apiKey
    );
}


