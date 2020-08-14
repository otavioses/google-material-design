package br.com.osouza.desafio.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.infrastructure.database.AlbumDAO;
import br.com.osouza.desafio.infrastructure.database.AlbumEntity;
import br.com.osouza.desafio.infrastructure.database.PostDAO;
import br.com.osouza.desafio.view.albums.AlbumsFragmentInterface;
import io.realm.Realm;
import io.realm.RealmChangeListener;

public class AlbumsPresenter implements AlbumsPresenterInterface {
    private AlbumsFragmentInterface mView;

    public AlbumsPresenter(AlbumsFragmentInterface view) {
        mView = view;
    }

    @Override
    public void getItems() {
        final AlbumDAO dao = new AlbumDAO();
        final List<AlbumEntity> albums = new ArrayList<>();
        albums.addAll(dao.getList(Realm.getDefaultInstance()));
        mView.updateItems(albums);
        Realm.getDefaultInstance().addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                albums.clear();
                albums.addAll(dao.getList(Realm.getDefaultInstance()));
                mView.updateItems(albums);
            }
        });
    }
}
