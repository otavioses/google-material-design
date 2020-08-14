package br.com.osouza.desafio.infrastructure.connection;

import java.util.List;

import br.com.osouza.desafio.model.Album;
import br.com.osouza.desafio.model.Post;
import br.com.osouza.desafio.model.ToDo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("albums")
    Call<List<Album>> getAlbums();

    @GET("todos")
    Call<List<ToDo>> getTodos();

}
