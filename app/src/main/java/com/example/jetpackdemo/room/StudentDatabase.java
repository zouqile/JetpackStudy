package com.example.jetpackdemo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {StudentEntity.class,}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase INSTANCE;

    //allowMainThreadQueries,测试功能允许主线程，使用可以用callback方式。回调回主线程
    static synchronized StudentDatabase getDataBase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, StudentDatabase.class, "student_databse")
//                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public abstract StudentDao getStudentDao();
}
