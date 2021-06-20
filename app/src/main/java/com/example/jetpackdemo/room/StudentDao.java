package com.example.jetpackdemo.room;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentDao {
    @Insert
    void insert(StudentEntity... Students);

    @Delete
    void delete(StudentEntity... Students);

    @Update
    void update(StudentEntity... Students);

    @Query("DELETE from student")
    void deleteAll();

    @Query("SELECT * from student  ORDER BY ID DESC")
    List<StudentEntity> getAll();

    @Query("SELECT * from student  ORDER BY ID DESC")
    LiveData<List<StudentEntity>> getAllLive();
}
