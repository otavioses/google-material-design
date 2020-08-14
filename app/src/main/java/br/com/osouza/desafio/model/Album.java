package br.com.osouza.desafio.model;

import br.com.osouza.desafio.infrastructure.database.AlbumEntity;

public class Album {
    private long userId;
    private long id;
    private String title;

    public Album() {
    }

    public Album(AlbumEntity albumEntity) {
        id = albumEntity.getId();
        userId = albumEntity.getUserId();
        title = albumEntity.getTitle();
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
