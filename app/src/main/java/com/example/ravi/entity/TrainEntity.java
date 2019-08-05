package com.example.ravi.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.example.ravi.utils.Constants.TRAIN_TABLE;

@Entity(tableName = TRAIN_TABLE)
public class TrainEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "uId")
    public int uId;
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "arrTime")
    public String arrTime;
    @ColumnInfo(name = "deparTime")
    public String deparTime;
    @ColumnInfo(name = "date")
    public String date;
    @ColumnInfo(name = "avalTrain")
    public String avalTrain;
    @ColumnInfo(name = "price")
    public String price;
    @ColumnInfo(name = "seats")
    public String seats;
    @ColumnInfo(name = "name")
    public String name;

    public TrainEntity() {

    }

    public TrainEntity(String username, String arrTime, String deparTime, String date, String avalTrain,
                       String price, String name, String seats) {
        this.username = username;
        this.arrTime = arrTime;
        this.deparTime = deparTime;
        this.date = date;
        this.avalTrain = avalTrain;
        this.price = price;
        this.name = name;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getDeparTime() {
        return deparTime;
    }

    public void setDeparTime(String deparTime) {
        this.deparTime = deparTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAvalTrain() {
        return avalTrain;
    }

    public void setAvalTrain(String avalTrain) {
        this.avalTrain = avalTrain;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
