package br.com.osouza.desafio.view.albums;

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
import br.com.osouza.desafio.model.Album;
import retrofit2.Call;
import retrofit2.Callback;

public class AlbumsFragment extends Fragment {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albums = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_albums, container, false);

        recyclerView = root.findViewById(R.id.albumsReciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new AlbumsAdapter(albums);
        recyclerView.setAdapter(adapter);

        JsonPlaceHolderApi service = ConnectionManager.createService(JsonPlaceHolderApi.class);

        Call<List<Album>> call = service.getAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, retrofit2.Response<List<Album>> response) {
                Log.d("", "");
                if (response.isSuccessful()) {
                    Log.d("", "");
                    albums.clear();
                    albums.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable e) {
                Log.d("", "");
            }
        });

        return root;
    }
}