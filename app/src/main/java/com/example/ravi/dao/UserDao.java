package com.example.ravi.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ravi.entity.UserEntity;

@Dao
public interface UserDao {
    @Insert
    void insert(UserEntity userEntity);

    @Query("UPDATE user_table SET address = :address, email = :email, photo = :photo WHERE user_table.id = :userId")
    void update(String userId, String address, String email, String photo);

    @Query("SELECT * FROM user_table WHERE user_table.id = :userId")
    UserEntity getUserDetails(String userId);

    @Query("SELECT id FROM user_table WHERE user_table.username = :username")
    int getId(String username);
}
