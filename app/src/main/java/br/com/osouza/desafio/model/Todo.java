package br.com.osouza.desafio.model;

public class Todo {
    private long userId;
    private long id;
    private String title;
    private Boolean completed;

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
