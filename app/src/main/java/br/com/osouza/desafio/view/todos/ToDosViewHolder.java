package br.com.osouza.desafio.view.todos;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.osouza.desafio.R;

public class ToDosViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageView completed;
    public ToDosViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        completed = itemView.findViewById(R.id.completed);
    }
}
