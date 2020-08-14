package br.com.osouza.desafio.view.albums;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.osouza.desafio.R;

public class AlbumsViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public AlbumsViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
    }
}
