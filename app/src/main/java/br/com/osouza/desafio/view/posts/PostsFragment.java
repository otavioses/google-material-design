package br.com.osouza.desafio.view.posts;

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
import br.com.osouza.desafio.infrastructure.database.PostEntity;
import br.com.osouza.desafio.presenter.posts.PostsPresenter;
import br.com.osouza.desafio.presenter.posts.PostsPresenterInterface;

public class PostsFragment extends Fragment implements PostsFragmentInterface {

    private PostsPresenterInterface mPresenter = new PostsPresenter(this);
    private RecyclerView recyclerView;
    private PostsAdapter adapter;
    private List<PostEntity> posts = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_posts, container, false);

        recyclerView = root.findViewById(R.id.postReciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new PostsAdapter(posts);
        recyclerView.setAdapter(adapter);

        mPresenter.getItems();

        return root;
    }

    @Override
    public void updateItems(List<PostEntity> list) {
        posts.clear();
        posts.addAll(list);
        adapter.notifyDataSetChanged();
    }
}