package br.com.osouza.desafio.view.todos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.osouza.desafio.R;
import br.com.osouza.desafio.infrastructure.database.ToDoDAO;
import br.com.osouza.desafio.infrastructure.database.ToDoEntity;
import io.realm.Realm;

public class ToDosFragment extends Fragment {
    private RecyclerView recyclerView;
    private TodosAdapter adapter;
    private List<ToDoEntity> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_todos, container, false);

        recyclerView = root.findViewById(R.id.todoReciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new TodosAdapter(list);
        recyclerView.setAdapter(adapter);

        ToDoDAO dao = new ToDoDAO();
        list.addAll(dao.getList(Realm.getDefaultInstance()));

        return root;
    }
}