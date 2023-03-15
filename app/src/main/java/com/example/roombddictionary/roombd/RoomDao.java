package com.example.roombddictionary.roombd;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roombddictionary.model.Model_dictionary;

import java.util.List;

@Dao
public interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSingleData(Model_dictionary studentInfo);


    @Query("SELECT * FROM dictionary_word")
    LiveData<List<Model_dictionary>> getAllData();

    @Query("SELECT * FROM person_table WHERE firstName LIKE :searchQuery OR lastName LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Person>>

}
