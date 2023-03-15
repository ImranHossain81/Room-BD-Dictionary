package com.example.roombddictionary.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.roombddictionary.model.Model_dictionary;
import com.example.roombddictionary.roombd.MyRoomDataBase;
import com.example.roombddictionary.roombd.RoomDao;

import java.util.List;

public class DictionaryRepository {

    private RoomDao roomDao;
    private MyRoomDataBase roomDataBase;
    private LiveData<List<Model_dictionary>> allData;
    private Context context;

    public DictionaryRepository(Context context) {
        this.context = context;
        roomDataBase = MyRoomDataBase.getInstance(context);
        roomDao = roomDataBase.roomDao();
        allData = roomDao.getAllData();
    }

    public LiveData<List<Model_dictionary>> getAllData(){
        return  this.allData;
    }

    public void insertSingleData(Model_dictionary studentInfo) {
        new InsertData(roomDao).execute(studentInfo);
    }

    private class InsertData extends AsyncTask<Model_dictionary, Void,Void> {
        RoomDao roomDao;
        public InsertData(RoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(Model_dictionary... studentInfos) {
            roomDao.insertSingleData(studentInfos[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(context, "Data insert Successful", Toast.LENGTH_SHORT).show();
        }
    }

}
