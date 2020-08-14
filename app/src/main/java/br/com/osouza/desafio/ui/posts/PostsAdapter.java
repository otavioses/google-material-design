package br.com.osouza.desafio.ui.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.osouza.desafio.R;
import br.com.osouza.desafio.model.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostsViewHolder> {
    private List<Post> posts;


    public PostsAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getBody());


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
