package br.com.osouza.desafio.view.albums;

import java.util.List;

import br.com.osouza.desafio.infrastructure.database.AlbumEntity;

public interface AlbumsFragmentInterface {
    void updateItems(List<AlbumEntity> list);
}
