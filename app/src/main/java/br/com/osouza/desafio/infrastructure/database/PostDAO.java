package br.com.osouza.desafio.infrastructure.database;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.model.Post;
import io.realm.Realm;

public class PostDAO {

    public List<PostEntity> getList(Realm realm) {
        return realm.where(PostEntity.class).findAll();
    }

    public void insertList(List<Post> list, Realm realm) {
        clearAll(realm);

        List<PostEntity> postEntities = new ArrayList<>();
        for (Post post: list) {
            postEntities.add(new PostEntity(post));
        }
        realm.beginTransaction();

        realm.copyToRealmOrUpdate(postEntities);
        realm.commitTransaction();
    }

    public void clearAll(Realm realm) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(PostEntity.class);
            }
        });

    }
}
