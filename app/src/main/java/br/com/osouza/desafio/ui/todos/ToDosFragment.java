package br.com.osouza.desafio.ui.todos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import br.com.osouza.desafio.R;

public class ToDosFragment extends Fragment {

    private ToDosViewModel todosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todosViewModel =
                new ViewModelProvider(this).get(ToDosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_todos, container, false);
        final TextView textView = root.findViewById(R.id.text_todos);
        todosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}