package com.example.jetpackdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

//如果需要环境，用//如果需要环境，用AndroidViewModel
public class StudentVM extends AndroidViewModel {

    public int age;


    public StudentVM(@NonNull Application application) {
        super(application);
    }
}
