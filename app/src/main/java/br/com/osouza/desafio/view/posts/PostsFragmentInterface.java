package br.com.osouza.desafio.view.posts;

import java.util.List;

import br.com.osouza.desafio.infrastructure.database.PostEntity;

public interface PostsFragmentInterface {
    void updateItems(List<PostEntity> list);
}
