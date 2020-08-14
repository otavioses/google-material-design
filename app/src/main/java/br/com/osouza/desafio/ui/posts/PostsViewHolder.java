package br.com.osouza.desafio.ui.posts;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.osouza.desafio.R;

public class PostsViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView body;
    public PostsViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        body = itemView.findViewById(R.id.body );
    }
}
