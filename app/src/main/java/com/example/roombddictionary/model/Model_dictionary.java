package com.example.roombddictionary.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dictionary_word")
public class Model_dictionary {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String English_word, বাংলা_শব্দ;


    public Model_dictionary() {

    }

    public Model_dictionary(String english_word, String বাংলা_শব্দ) {
        this.English_word = english_word;
        this.বাংলা_শব্দ = বাংলা_শব্দ;
    }

    public String getEnglish_word() {
        return English_word;
    }

    public void setEnglish_word(String english_word) {
        English_word = english_word;
    }

    public String getবাংলা_শব্দ() {
        return বাংলা_শব্দ;
    }

    public void setবাংলা_শব্দ(String বাংলা_শব্দ) {
        this.বাংলা_শব্দ = বাংলা_শব্দ;
    }
}
