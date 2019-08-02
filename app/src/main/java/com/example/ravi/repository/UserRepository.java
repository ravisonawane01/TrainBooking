package com.example.ravi.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.ravi.dao.UserDao;
import com.example.ravi.entity.UserEntity;

public class UserRepository {

    private static UserRepository instance;
    private final UserDao userDao;
    private LiveData<UserEntity> useLiveData;

    private UserRepository(UserDao userAccountDao) {
        this.userDao = userAccountDao;
    }

    public static UserRepository getInstance(UserDao userDao) {
        if (instance == null) {
            instance = new UserRepository(userDao);
        }
        return instance;
    }

    public boolean isValidAccount(String username, final String password) {

        UserEntity userEntity = userDao.getUserDetails(username);
        return userEntity.getPassword().equals(password);
    }

    public void insertUser(String name, String address, String pincode, String mobile,
                           String email, @NonNull String username, String password, String photo) {

        UserEntity userEntity = new UserEntity(name, address, pincode, mobile,
                email, username, password, photo);
        userDao.insert(userEntity);
    }
}
