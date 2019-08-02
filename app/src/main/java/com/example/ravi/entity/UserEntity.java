package com.example.ravi.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.example.ravi.entity.UserEntity.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class UserEntity {

    public static final String TABLE_NAME = "user_table";

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    String username;
    @ColumnInfo(name = "password")
    String password;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "address")
    String address;
    @ColumnInfo(name = "pincode")
    String pincode;
    @ColumnInfo(name = "mobile")
    String mobile;
    @ColumnInfo(name = "email")
    String email;
    @ColumnInfo(name = "photo")
    String photo;

    public UserEntity() {

    }

    public UserEntity(String name, String address, String pincode, String mobile,
                      String email, @NonNull String username, String password, String photo) {
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
