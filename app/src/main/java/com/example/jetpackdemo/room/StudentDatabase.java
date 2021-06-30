package com.example.jetpackdemo.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {StudentEntity.class,}, version = 2, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase INSTANCE;

    //allowMainThreadQueries,测试功能允许主线程，使用可以用callback方式。回调回主线程
    static synchronized StudentDatabase getDataBase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, StudentDatabase.class, "student_databse")
//                    .allowMainThreadQueries()
//                    .fallbackToDestructiveMigration()//会清空数据的版本升级
                    .addMigrations(MIGRATION_1_2)//版本从1,2.不会清空数据
                    .build();
        }
        return INSTANCE;
    }


    //版本升级操作，版本从1到2
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //student表新增字段test
            database.execSQL("alter table student add column test integer not null default 0");

        }
    };


    public abstract StudentDao getStudentDao();
}
