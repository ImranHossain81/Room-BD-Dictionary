package com.example.roombddictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roombddictionary.R;
import com.example.roombddictionary.model.Model_dictionary;

import java.util.ArrayList;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.MyHolder> {

    ArrayList<Model_dictionary> modelDictionaryRooms;
    Context context;

    public DictionaryAdapter(ArrayList<Model_dictionary> modelDictionaryRooms, Context context) {
        this.modelDictionaryRooms = modelDictionaryRooms;
        this.context = context;
    }

    @NonNull
    @Override
    public DictionaryAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dictionary,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DictionaryAdapter.MyHolder holder, int position) {

        holder.English_word.setText(""+modelDictionaryRooms.get(position).getEnglish_word());
        holder.বাংলা_শব্দ.setText(""+modelDictionaryRooms.get(position).getবাংলা_শব্দ());

    }

    @Override
    public int getItemCount() {
        return modelDictionaryRooms.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView English_word, বাংলা_শব্দ;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            English_word=itemView.findViewById(R.id.English_word);
            বাংলা_শব্দ=itemView.findViewById(R.id.Bengali_word);
        }
    }
}
