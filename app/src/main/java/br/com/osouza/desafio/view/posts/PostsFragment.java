package br.com.osouza.desafio.view.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.R;
import br.com.osouza.desafio.infrastructure.connection.ConnectionManager;
import br.com.osouza.desafio.infrastructure.connection.JsonPlaceHolderApi;
import br.com.osouza.desafio.infrastructure.database.PostListDAO;
import br.com.osouza.desafio.model.Post;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;

public class PostsFragment extends Fragment {

    private RecyclerView recyclerView;
    private PostsAdapter adapter;
    private List<Post> posts = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_posts, container, false);

        recyclerView = root.findViewById(R.id.postReciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new PostsAdapter(posts);
        recyclerView.setAdapter(adapter);

        PostListDAO dao = new PostListDAO();
        posts.addAll(dao.getList(Realm.getDefaultInstance()));

//
//        JsonPlaceHolderApi service = ConnectionManager.createService(JsonPlaceHolderApi.class);
//
//        Call<List<Post>> call = service.getPosts();
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, retrofit2.Response<List<Post>> response) {
//                Log.d("", "");
//                if (response.isSuccessful()) {
//                    Log.d("", "");
//                    posts.clear();
//                    posts.addAll(response.body());
//                    adapter.notifyDataSetChanged();
//                }
//            }
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable e) {
//                Log.d("", "");
//            }
//        });

        return root;
    }

}