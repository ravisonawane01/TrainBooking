package com.example.ravi.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.ravi.dao.TrainDao;
import com.example.ravi.entity.TrainEntity;
import com.example.ravi.utils.SharePrefUtil;

import java.util.List;
import java.util.Random;

public class TrainRepository {

    private static TrainRepository instance;
    private final TrainDao trainDao;

    private TrainRepository(TrainDao trainDao) {
        this.trainDao = trainDao;
    }

    public static TrainRepository getInstance(TrainDao TrainDao) {
        if (instance == null) {
            instance = new TrainRepository(TrainDao);
        }
        return instance;
    }

    public LiveData<List<TrainEntity>> fetchDetails(String userId) {
        return trainDao.getTrainDetails(userId);
    }

    public TrainEntity insertTrain(int userId, String arrTime, String deparTime, String date, String avalTrain,
                            String price, String name, String seats) {

        TrainEntity trainEntity = new TrainEntity(userId, arrTime, deparTime, date, avalTrain,
                price, name, seats);
        trainDao.insert(trainEntity);
        return trainEntity;
    }
}
