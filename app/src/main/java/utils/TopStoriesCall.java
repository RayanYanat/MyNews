package utils;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import models.TopStoriesArticles;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopStoriesCall {

    public interface Callbacks {
        void onResponse(List<TopStoriesArticles> topstories);

        void onFailure();
    }

    public static void fetchTopStoriesArticle(Callbacks callbacks, String section) {

        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<>(callbacks);

        NytimesService nytimesService = NytimesService.retrofit.create(NytimesService.class);

        Call<List<TopStoriesArticles>> call = nytimesService.getTopStoriesNews(section);

        call.enqueue(new Callback<List<TopStoriesArticles>>() {

            @Override
            public void onResponse(Call<List<TopStoriesArticles>> call, Response<List<TopStoriesArticles>> response) {
                Log.d("TAG","Response = ");
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }



            @Override
            public void onFailure(Call<List<TopStoriesArticles>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}

