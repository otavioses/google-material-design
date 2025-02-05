package br.com.osouza.desafio.view.todos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.osouza.desafio.R;
import br.com.osouza.desafio.infrastructure.database.ToDoEntity;

public class TodosAdapter extends RecyclerView.Adapter<ToDosViewHolder> {
    private List<ToDoEntity> toDos;


    public TodosAdapter(List<ToDoEntity> toDos) {
        this.toDos = toDos;
    }

    @NonNull
    @Override
    public ToDosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new ToDosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDosViewHolder holder, int position) {
        ToDoEntity todo = toDos.get(position);
        holder.title.setText(todo.getTitle());
        if (todo.getCompleted()) {
            holder.completed.setImageResource(R.drawable.ic_baseline_done_24);
            holder.completed.setBackgroundResource(R.color.colorGreenDone);
        } else {
            holder.completed.setImageResource(R.drawable.ic_baseline_undone_24);
            holder.completed.setBackgroundResource(R.color.colorOrangeUndone);
        }
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }
}
