package com.example.ravi.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ravi.entity.UserEntity;

@Dao
public interface UserDao {
    @Insert
    void insert(UserEntity userEntity);

    @Query("SELECT * FROM user_table WHERE user_table.username LIKE :username")
    UserEntity getUserDetails(String username);
}
