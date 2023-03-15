package com.example.roombddictionary.roombd;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.roombddictionary.model.Model_dictionary;

@Database(entities = Model_dictionary.class,version = 1,exportSchema = false)
public abstract class MyRoomDataBase extends RoomDatabase {

    private static MyRoomDataBase roomDataBase = null;

    public abstract RoomDao roomDao();

    public static synchronized MyRoomDataBase getInstance(Context context)
    {
        if (roomDataBase==null)
        {
            roomDataBase = Room.databaseBuilder(context, MyRoomDataBase.class,"dictionarydb")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return roomDataBase;
    }


}
