package com.example.ravi.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ravi.dao.UserDao;
import com.example.ravi.entity.UserEntity;
import com.example.ravi.sqlAsset.AssetSQLiteOpenHelperFactory;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public static UserDatabase INSTANCE;

    public static UserDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {

            synchronized (UserDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, "user-database.db")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            //.fallbackToDestructiveMigration()
                            //.openHelperFactory(new AssetSQLiteOpenHelperFactory())
                            .allowMainThreadQueries()
                            .build();
                }

            }

        }

        return INSTANCE;

    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract UserDao userDao();
}
