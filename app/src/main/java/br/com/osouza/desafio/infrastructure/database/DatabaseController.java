package br.com.osouza.desafio.infrastructure.database;

import android.content.Context;
import android.util.Log;

import java.util.List;

import br.com.osouza.desafio.infrastructure.connection.ConnectionManager;
import br.com.osouza.desafio.infrastructure.connection.JsonPlaceHolderApi;
import br.com.osouza.desafio.model.Album;
import br.com.osouza.desafio.model.Post;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;

public class DatabaseController {

    public static void startRealm(Context context) {
        Realm.init(context);
        try {
            RealmSetup realmSetup = new RealmSetup(context);
            Realm.setDefaultConfiguration(realmSetup.getRealmConfiguration());
            updateDatabases();
        } catch (Exception e) {
        }
    }

    public static  void updateDatabases() {
        updatePostsDatabase();
        updateAlbumsDatabase();
    }

    private static void updatePostsDatabase() {
        JsonPlaceHolderApi service = ConnectionManager.createService(JsonPlaceHolderApi.class);

        Call<List<Post>> call = service.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, retrofit2.Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    PostDAO postDAO = new PostDAO();
                    postDAO.insertList(response.body(),Realm.getDefaultInstance());
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable e) {
                Log.d("", "");
            }
        });
    }

    private static void updateAlbumsDatabase() {
        JsonPlaceHolderApi service = ConnectionManager.createService(JsonPlaceHolderApi.class);

        Call<List<Album>> call = service.getAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, retrofit2.Response<List<Album>> response) {
                if (response.isSuccessful()) {
                    AlbumDAO albumDAO = new AlbumDAO();
                    albumDAO.insertList(response.body(),Realm.getDefaultInstance());
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable e) {
                Log.d("", "");
            }
        });
    }
}
