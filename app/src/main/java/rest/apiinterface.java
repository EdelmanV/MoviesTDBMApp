package rest;

import retrofit2.Call;
import  model2.movieresponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;




public class apiinterface {
    //movie/top_rated
    @GET(value = "movie/top_dated")
    Call<movieresponse> getTopRatedMovies(@Query("api_key") String apiKey) {
        return null;
    }

    @GET("movie/{id}")
    Call<movieresponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey) {
        return null;
    }
}



