package com.example.ravi.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.ravi.database.UserDatabase;
import com.example.ravi.entity.TrainEntity;
import com.example.ravi.repository.TrainRepository;

import java.util.List;

public class TrainViewModel extends ViewModel {

    TrainRepository trainRepository;

    public TrainViewModel(Context context) {
        trainRepository = TrainRepository.getInstance(UserDatabase.getDatabase(context).trainDao());
    }

    public void createTrain(int userId, String arrTime, String deparTime, String date, String avalTrain,
                            String price, String name, String seats) {

        trainRepository.insertTrain(userId, arrTime, deparTime, date, avalTrain,
                price, name, seats);
    }

    public LiveData<List<TrainEntity>> getTrainDetails(String uId) {
        return trainRepository.fetchDetails(uId);
    }

    /**
     * IF we want to share same ViewModel with another class, Use ViewModelProvider.NewInstanceFactory
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private final Context ctxt;

        public Factory(Context ctxt) {
            this.ctxt = ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return ((T) new TrainViewModel(ctxt));
        }
    }
}
