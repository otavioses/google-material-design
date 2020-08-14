package br.com.osouza.desafio.presenter.posts;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.infrastructure.database.PostDAO;
import br.com.osouza.desafio.infrastructure.database.PostEntity;
import br.com.osouza.desafio.view.posts.PostsFragmentInterface;
import io.realm.Realm;
import io.realm.RealmChangeListener;

public class PostsPresenter implements PostsPresenterInterface {
    private PostsFragmentInterface mView;

    public PostsPresenter(PostsFragmentInterface view) {
        mView = view;
    }

    @Override
    public void getItems() {
        final PostDAO dao = new PostDAO();
        final List<PostEntity> posts = new ArrayList<>();
        posts.addAll(dao.getList(Realm.getDefaultInstance()));
        mView.updateItems(posts);
        Realm.getDefaultInstance().addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                posts.clear();
                posts.addAll(dao.getList(Realm.getDefaultInstance()));
                mView.updateItems(posts);
            }
        });
    }
}
