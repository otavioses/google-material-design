package br.com.osouza.desafio.infrastructure.database;

import br.com.osouza.desafio.model.Post;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PostEntity extends RealmObject {

    @PrimaryKey
    private long id = 0;
    private long userId = 0;
    private String title = "";
    private String body = "";

    public PostEntity() {
    }

    public PostEntity(Post post) {
        id = post.getId();
        userId = post.getUserId();
        title = post.getTitle();
        body = post.getBody();
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
