package br.com.osouza.desafio.infrastructure.database;

import android.content.Context;
import android.util.Log;

import java.util.List;

import br.com.osouza.desafio.infrastructure.connection.ConnectionManager;
import br.com.osouza.desafio.infrastructure.connection.JsonPlaceHolderApi;
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
        } catch (Exception e) {
        }
    }

    public static  void updateDatabases() {
        updatePostsDatabase();
    }

    private static void updatePostsDatabase() {
        JsonPlaceHolderApi service = ConnectionManager.createService(JsonPlaceHolderApi.class);

        Call<List<Post>> call = service.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, retrofit2.Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    PostListDAO postListDAO = new PostListDAO();
                    postListDAO.insertList(response.body(),Realm.getDefaultInstance());
                    updateDatabases();
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable e) {
                Log.d("", "");
            }
        });
    }
}
