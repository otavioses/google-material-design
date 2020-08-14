package br.com.osouza.desafio.infrastructure.database;

import br.com.osouza.desafio.model.Album;
import br.com.osouza.desafio.model.Post;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AlbumEntity  extends RealmObject {
    @PrimaryKey
    private long id;
    private long userId;
    private String title;

    public AlbumEntity() {
    }

    public AlbumEntity(Album album) {
        id = album.getId();
        userId = album.getUserId();
        title = album.getTitle();
    }

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
