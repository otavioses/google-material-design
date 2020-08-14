package br.com.osouza.desafio.model;

import br.com.osouza.desafio.infrastructure.database.ToDoEntity;

public class ToDo {
    private long userId;
    private long id;
    private String title;
    private Boolean completed;

    public ToDo() {
    }

    public ToDo(ToDoEntity toDoEntity) {
        id = toDoEntity.getId();
        userId = toDoEntity.getUserId();
        title = toDoEntity.getTitle();
        completed = toDoEntity.getCompleted();
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
