package br.com.osouza.desafio.view.todos;

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
import br.com.osouza.desafio.infrastructure.ConnectionManager;
import br.com.osouza.desafio.infrastructure.JsonPlaceHolderApi;
import br.com.osouza.desafio.model.Todo;
import retrofit2.Call;
import retrofit2.Callback;

public class ToDosFragment extends Fragment {
    private RecyclerView recyclerView;
    private TodosAdapter adapter;
    private List<Todo> posts = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_todos, container, false);

        recyclerView = root.findViewById(R.id.todoReciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new TodosAdapter(posts);
        recyclerView.setAdapter(adapter);

        JsonPlaceHolderApi service = ConnectionManager.createService(JsonPlaceHolderApi.class);

        Call<List<Todo>> call = service.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, retrofit2.Response<List<Todo>> response) {
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
            public void onFailure(Call<List<Todo>> call, Throwable e) {
                Log.d("", "");
            }
        });

        return root;
    }
}