package br.com.osouza.desafio.view.albums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.osouza.desafio.R;
import br.com.osouza.desafio.model.Album;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsViewHolder> {
    private List<Album> albums;


    public AlbumsAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new AlbumsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.title.setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}
