package utils;

        import java.util.List;

        import models.TopStoriesArticles;
        import retrofit2.Call;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;
        import retrofit2.http.GET;
        import retrofit2.http.Path;

public interface NytimesService {

    String API_KEY = "api-key=JBjJiEna1ALjDhOOSlBMTj7ej1D55z1O";

    @GET("topstories/v2/{section}.json?" + API_KEY)
    Call<List<TopStoriesArticles>>getTopStoriesNews(@Path("section") String section);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build() ;

}
