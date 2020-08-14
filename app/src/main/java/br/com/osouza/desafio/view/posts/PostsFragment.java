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
import br.com.osouza.desafio.infrastructure.database.PostDAO;
import br.com.osouza.desafio.infrastructure.database.PostEntity;
import br.com.osouza.desafio.model.Post;
import io.realm.Realm;
import io.realm.RealmChangeListener;

public class PostsFragment extends Fragment {

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

        PostDAO dao = new PostDAO();
        posts.addAll(dao.getList(Realm.getDefaultInstance()));
        Realm.getDefaultInstance().addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                PostDAO dao = new PostDAO();
                posts.addAll(dao.getList(Realm.getDefaultInstance()));
                adapter.notifyDataSetChanged();
            }
        });

        return root;
    }

}