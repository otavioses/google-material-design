package br.com.osouza.desafio.view.todos;

import java.util.List;

import br.com.osouza.desafio.infrastructure.database.ToDoEntity;

public interface TodosFragmentInterface {
    void updateItems(List<ToDoEntity> list);
}
