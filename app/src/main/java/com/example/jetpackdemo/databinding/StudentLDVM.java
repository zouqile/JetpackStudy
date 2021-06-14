package com.example.jetpackdemo.databinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudentLDVM extends ViewModel {
    private MutableLiveData<Integer> ageLD;

    public MutableLiveData<Integer> getAgeLD() {
        if (ageLD == null) {
            ageLD = new MutableLiveData<>();
            ageLD.setValue(0);
        }
        return ageLD;
    }


    public void addAge(int age) {
        getAgeLD().setValue(getAgeLD().getValue() + age);

    }
}
