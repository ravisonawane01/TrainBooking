package com.example.ravi.repository;

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
        if (userEntity != null) {
            if (userEntity.getPassword() != null) {
                return userEntity.getPassword().equals(password);
            }
        }
        return false;
    }

    public UserEntity fetchDetails(String userId) {
        return userDao.getUserDetails(userId);
    }

    public void insertUser(String name, String address, String pincode, String mobile,
                           String email, String username, String password, String photo) {

        UserEntity userEntity = new UserEntity(name, address, pincode, mobile,
                email, username, password, photo);

        userDao.insert(userEntity);
    }

    public void updateUser(String userId, String address, String email, String photo) {
        userDao.update(userId, address, email, photo);
    }

    public int getId(String username) {
        return userDao.getId(username);
    }
}
