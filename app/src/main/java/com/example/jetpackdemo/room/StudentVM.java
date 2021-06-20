package com.example.jetpackdemo.room;

import android.app.Application;

import com.example.jetpackdemo.CompletionListener;
import com.example.jetpackdemo.ThreadUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class StudentVM extends AndroidViewModel {


    private StudentRepository studentRepository;

    public StudentVM(@NonNull Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
    }

    public LiveData<List<StudentEntity>> getAllLive() {
        return studentRepository.getAllLive();
    }


    public void insert(StudentEntity... Students) {

        studentRepository.insert(Students);

    }

    public void delete(StudentEntity... Students) {
        studentRepository.delete(Students);

    }

    public void update(StudentEntity... Students) {
        studentRepository.update(Students);

    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public void getAll(CompletionListener<List<StudentEntity>> listener) {
        studentRepository.getAll(listener);
    }




}
