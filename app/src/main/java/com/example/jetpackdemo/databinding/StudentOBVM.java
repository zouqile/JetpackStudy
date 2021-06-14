package com.example.jetpackdemo.databinding;

import com.example.jetpackdemo.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class StudentOBVM extends BaseObservable {
    private String name;
    private Integer age;


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
