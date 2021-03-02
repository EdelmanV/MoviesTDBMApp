package rest;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class apiclient {
    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/550?api_key=c2748f1e4940511dac6a36c7f7c0a07b";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
