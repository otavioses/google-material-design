package br.com.osouza.desafio.infrastructure;

import com.google.gson.Gson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.osouza.desafio.model.Album;
import br.com.osouza.desafio.model.Post;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Url;
import okhttp3.RequestBody;
import retrofit2.Call;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("albums")
    Call<List<Album>> getAlbums();

}
