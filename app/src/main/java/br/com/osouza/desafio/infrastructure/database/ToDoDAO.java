package br.com.osouza.desafio.infrastructure.database;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.model.ToDo;
import io.realm.Realm;

public class ToDoDAO {

    public List<ToDoEntity> getList(Realm realm) {
        return realm.where(ToDoEntity.class).findAll();
    }

    public void insertList(List<ToDo> list, Realm realm) {
        clearAll(realm);
        List<ToDoEntity> toDoEntities = new ArrayList<>();
        for (ToDo toDo : list) {
            toDoEntities.add(new ToDoEntity(toDo));
        }
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(toDoEntities);
        realm.commitTransaction();
    }

    public void clearAll(Realm realm) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(ToDoEntity.class);
            }
        });
    }
}
