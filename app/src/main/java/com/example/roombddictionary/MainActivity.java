package com.example.roombddictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.roombddictionary.adapter.DictionaryAdapter;
import com.example.roombddictionary.model.Model_dictionary;
import com.example.roombddictionary.repository.DictionaryRepository;
import com.example.roombddictionary.roombd.RoomDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<ActivityListBinding> extends AppCompatActivity {

    EditText  Enter_the_English, Enter_the_Bangla;

    DictionaryRepository repository;
    RecyclerView recyclerView;
    DictionaryAdapter dictionaryAdapter;
    RoomDao roomDao;

    private ActivityListBinding binding;
    ArrayList< Model_dictionary> persons=new ArrayList<>();

    ArrayList<Model_dictionary> dictionarylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repository = new DictionaryRepository(getApplicationContext());
        Enter_the_English=findViewById(R.id.et_english);
        Enter_the_Bangla=findViewById(R.id.et_bangla);

        recyclerView = findViewById(R.id.recyclerViewStudent);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        dictionaryAdapter = new DictionaryAdapter(dictionarylist,getApplicationContext());
        recyclerView.setAdapter(dictionaryAdapter);

        getData();


    }

    private void getData() {
        repository.getAllData().observe(this, new Observer<List<Model_dictionary>>() {
            @Override
            public void onChanged(List<Model_dictionary> modelStudentInfoslist) {
                dictionarylist.clear();
                dictionarylist.addAll(modelStudentInfoslist);
                dictionaryAdapter.notifyDataSetChanged();
            }
        });


    }

    public void savebtn(View view) {

        String dic_English_word, dic_বাংলা_শব্দ;
        dic_English_word = Enter_the_English.getText().toString();
        dic_বাংলা_শব্দ = Enter_the_Bangla.getText().toString();




        repository.insertSingleData(new Model_dictionary(dic_English_word, dic_বাংলা_শব্দ));


    }



}