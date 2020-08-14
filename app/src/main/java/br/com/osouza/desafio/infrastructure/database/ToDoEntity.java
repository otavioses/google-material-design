package br.com.osouza.desafio.infrastructure.database;

import br.com.osouza.desafio.model.Post;
import br.com.osouza.desafio.model.ToDo;
import io.realm.RealmObject;

public class ToDoEntity  extends RealmObject {
    private long id;
    private long userId;
    private String title;
    private Boolean completed;

    public ToDoEntity() {
    }

    public ToDoEntity(ToDo post) {
        id = post.getId();
        userId = post.getUserId();
        title = post.getTitle();
        completed = post.getCompleted();
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

    public Boolean getCompleted() {
        return completed;
    }
}
