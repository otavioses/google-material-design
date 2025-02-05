package br.com.osouza.desafio.infrastructure.database;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.model.Album;
import io.realm.Realm;

public class AlbumDAO {
    public List<AlbumEntity> getList(Realm realm) {
        return realm.where(AlbumEntity.class).findAll();
    }

    public void insertList(List<Album> list, Realm realm) {
        clearAll(realm);
        List<AlbumEntity> postEntities = new ArrayList<>();
        for (Album album : list) {
            postEntities.add(new AlbumEntity(album));
        }
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(postEntities);
        realm.commitTransaction();
    }

    public void clearAll(Realm realm) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(AlbumEntity.class);
            }
        });
    }
}
