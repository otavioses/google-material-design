package br.com.osouza.desafio.model;

import br.com.osouza.desafio.infrastructure.database.PostEntity;

public class Post {
    private long userId;
    private long id;
    private String title;
    private String body;

    public Post() {
    }

    public Post(PostEntity postEntity) {
        id = postEntity.getId();
        userId = postEntity.getUserId();
        title = postEntity.getTitle();
        body = postEntity.getBody();
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

    public String getBody() {
        return body;
    }
}
