package com.example.ravi.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ravi.entity.TrainEntity;

import java.util.List;

@Dao
public interface TrainDao {

    @Insert
    void insert(TrainEntity trainEntity);

    @Query("SELECT * FROM train_table WHERE id = :id ORDER BY name ASC")
    LiveData<List<TrainEntity>> getTrainDetails(String id);
}
