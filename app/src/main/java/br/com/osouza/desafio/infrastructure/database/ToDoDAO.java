package br.com.osouza.desafio.infrastructure.database;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.model.Post;
import br.com.osouza.desafio.model.ToDo;
import io.realm.Realm;

public class ToDoDAO {

    public List<ToDo> getList(Realm realm) {
        List<ToDoEntity> toDoEntities = realm.where(ToDoEntity.class).findAll();
        List<ToDo> list = new ArrayList<>();
        for (ToDoEntity toDoEntity: toDoEntities) {
            list.add(new ToDo(toDoEntity));
        }
        return list;
    }

    public void insertList(List<ToDo> list, Realm realm) {
        List<ToDoEntity> toDoEntities = new ArrayList<>();
        for (ToDo toDo: list) {
            toDoEntities.add(new ToDoEntity(toDo));
        }
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(toDoEntities);
        realm.commitTransaction();
    }
}
