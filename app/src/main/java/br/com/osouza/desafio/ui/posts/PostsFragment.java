package br.com.osouza.desafio.ui.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.R;
import br.com.osouza.desafio.infrastructure.ConnectionManager;
import br.com.osouza.desafio.infrastructure.JsonPlaceHolderApi;
import br.com.osouza.desafio.infrastructure.PostResponse;
import br.com.osouza.desafio.model.Post;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class PostsFragment extends Fragment {

    private PostsViewModel postsViewModel;
    private RecyclerView recyclerView;
    private PostsAdapter adapter;
    private List<Post> posts = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        postsViewModel = new ViewModelProvider(this).get(PostsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_posts, container, false);

        recyclerView = root.findViewById(R.id.reciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new PostsAdapter(posts);
        recyclerView.setAdapter(adapter);

        JsonPlaceHolderApi service = ConnectionManager.createService(JsonPlaceHolderApi.class);

        Call<List<Post>> call = service.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, retrofit2.Response<List<Post>> response) {
                Log.d("", "");
                if (response.isSuccessful()) {
                    Log.d("", "");
                    posts.clear();
                    posts.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable e) {
                Log.d("", "");
            }
        });

        return root;
    }

}