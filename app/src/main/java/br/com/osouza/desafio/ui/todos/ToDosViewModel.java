package br.com.osouza.desafio.ui.todos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToDosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToDosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow ToDosViewModel");
    }

    public LiveData<String> getText() {
        return mText;
    }
}