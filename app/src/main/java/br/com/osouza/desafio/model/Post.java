package br.com.osouza.desafio.model;

public class Post {
    private long userId;
    private long id;
    private String title;
    private String body;

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
