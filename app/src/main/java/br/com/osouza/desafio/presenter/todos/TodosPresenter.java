package br.com.osouza.desafio.presenter.todos;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.infrastructure.database.ToDoDAO;
import br.com.osouza.desafio.infrastructure.database.ToDoEntity;
import br.com.osouza.desafio.view.todos.TodosFragmentInterface;
import io.realm.Realm;
import io.realm.RealmChangeListener;

public class TodosPresenter implements TodosPresenterInterface {

    private TodosFragmentInterface mView;

    public TodosPresenter(TodosFragmentInterface view) {
        mView = view;
    }
    @Override
    public void getItems() {
        final ToDoDAO dao = new ToDoDAO();
        final List<ToDoEntity> toDoEntities = new ArrayList<>();
        toDoEntities.addAll(dao.getList(Realm.getDefaultInstance()));
        mView.updateItems(toDoEntities);
        Realm.getDefaultInstance().addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                toDoEntities.clear();
                toDoEntities.addAll(dao.getList(Realm.getDefaultInstance()));
                mView.updateItems(toDoEntities);
            }
        });
    }
}
