package br.com.osouza.desafio.infrastructure.database;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.model.Album;
import br.com.osouza.desafio.model.Post;
import io.realm.Realm;

public class AlbumDAO {
    public List<Album> getList(Realm realm) {
        List<AlbumEntity> albumEntities = realm.where(AlbumEntity.class).findAll();
        List<Album> list = new ArrayList<>();
        for (AlbumEntity post: albumEntities) {
            list.add(new Album(post));
        }
        return list;
    }

    public void insertList(List<Album> list, Realm realm) {
        List<AlbumEntity> postEntities = new ArrayList<>();
        for (Album album: list) {
            postEntities.add(new AlbumEntity(album));
        }
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(postEntities);
        realm.commitTransaction();
    }
}
