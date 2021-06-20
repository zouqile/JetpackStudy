package com.example.jetpackdemo.room;

import android.content.Context;

import com.example.jetpackdemo.CompletionListener;
import com.example.jetpackdemo.ThreadUtil;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

public class StudentRepository {

    private StudentDao dao;
    private LiveData<List<StudentEntity>> studentsLive;

    public StudentRepository(Context context) {
        dao = StudentDatabase.getDataBase(context).getStudentDao();
        studentsLive = dao.getAllLive();
    }

    public LiveData<List<StudentEntity>> getAllLive() {
        return studentsLive;
    }


    public void insert(StudentEntity... Students) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insert(Students);
            }
        }).start();

    }

    public void delete(StudentEntity... Students) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.delete(Students);
            }
        }).start();

    }

    public void update(StudentEntity... Students) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.update(Students);
            }
        }).start();

    }


    public void getAll(CompletionListener<List<StudentEntity>> listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<StudentEntity> list = dao.getAll();
                    ThreadUtil.main(new Runnable() {
                        @Override
                        public void run() {
                            listener.onSuccess(list);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    listener.onFail(e.getMessage());
                    return;
                }
            }
        }).start();

    }


    public void deleteAll() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteAll();
            }
        }).start();

    }


}
