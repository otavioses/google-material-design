package br.com.osouza.desafio.view.albums;

import android.os.Bundle;
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
import br.com.osouza.desafio.infrastructure.database.AlbumEntity;
import br.com.osouza.desafio.presenter.albums.AlbumsPresenter;
import br.com.osouza.desafio.presenter.albums.AlbumsPresenterInterface;

public class AlbumsFragment extends Fragment implements AlbumsFragmentInterface {

    private AlbumsPresenterInterface mPresenter = new AlbumsPresenter(this);
    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<AlbumEntity> albums = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_albums, container, false);

        recyclerView = root.findViewById(R.id.albumsReciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new AlbumsAdapter(albums);
        recyclerView.setAdapter(adapter);

        mPresenter.getItems();

        return root;
    }

    @Override
    public void updateItems(List<AlbumEntity> list) {
        albums.clear();
        albums.addAll(list);
        adapter.notifyDataSetChanged();
    }
}