package br.com.osouza.desafio.infrastructure.database;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.model.Post;
import io.realm.Realm;

public class PostListDAO {

    public List<Post> getList(Realm realm) {
        List<PostEntity> postEntities = realm.where(PostEntity.class).findAll();
        List<Post> list = new ArrayList<>();
        for (PostEntity post: postEntities) {
            list.add(new Post(post));
        }
        return list;
    }

    public void insertList(List<Post> list, Realm realm) {
        List<PostEntity> postEntities = new ArrayList<>();
        for (Post post: list) {
            postEntities.add(new PostEntity(post));
        }
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(postEntities);
        realm.commitTransaction();
    }
}
