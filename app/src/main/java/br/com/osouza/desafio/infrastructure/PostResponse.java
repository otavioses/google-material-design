package br.com.osouza.desafio.infrastructure;

import java.util.List;

import br.com.osouza.desafio.model.Post;

public class PostResponse {
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }
}
