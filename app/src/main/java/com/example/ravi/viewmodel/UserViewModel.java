package com.example.ravi.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.ravi.database.UserDatabase;
import com.example.ravi.entity.UserEntity;
import com.example.ravi.repository.UserRepository;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;
    private UserEntity userEntity;

    public UserViewModel(Context context) {
        userRepository = UserRepository.getInstance(UserDatabase.getDatabase(context).userDao());
    }

    public void createUser(String name, String address, String pincode, String mobile,
                           String email, String username, String password, String photo) {

        userRepository.insertUser(name, address, pincode, mobile,
                email, username, password, photo);
    }

    public void editUser(String userId, String address, String email, String photo) {
        userRepository.updateUser(userId, address, email, photo);
    }

    public boolean checkValidLogin(String username, String password) {
        return userRepository.isValidAccount(username, password);
    }

    public UserEntity getUserDetails(String userId) {
        return userRepository.fetchDetails(userId);
    }

    public int getId(String username){
        return userRepository.getId(username);
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
            return ((T) new UserViewModel(ctxt));
        }
    }
}
