package me.davidlake.lumos.network;

import me.davidlake.lumos.model.asteroid.AsteroidFeed;
import me.davidlake.lumos.service.AsteroidService;
import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public final class NeoApi {

    private final Retrofit retrofit;

    private final AsteroidService asteroidService;

    private final String apiKey;

    private int rateLimit = -1;

    private int rateLimitRemaining = -1;

    public NeoApi() {
        this("");
    }

    public NeoApi(final String apiKey) {
        retrofit = new Retrofit.Builder().baseUrl("https://api.nasa.gov").addConverterFactory(GsonConverterFactory
                .create()).build();
        asteroidService = retrofit.create(AsteroidService.class);
        this.apiKey = apiKey;
    }

    public AsteroidFeed getAsteroidFeed(final String startDate, final String endDate)
            throws IOException {
        return get(asteroidService.feed(startDate, endDate, apiKey));
    }

    private <T> T get(final Call<T> call) throws IOException {
        final Response<T> response = call.execute();
        final Headers headers = response.headers();
        rateLimit = Integer.parseInt(headers.get("X-RateLimit-Limit"));
        rateLimitRemaining = Integer.parseInt(headers.get("X-RateLimit-Remaining"));
        return response.body();
    }

    public int getRateLimit() {
        return rateLimit;
    }

    public int getRateLimitRemaining() {
        return rateLimitRemaining;
    }
}