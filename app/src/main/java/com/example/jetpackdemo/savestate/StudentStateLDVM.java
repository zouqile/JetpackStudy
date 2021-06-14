package com.example.jetpackdemo.savestate;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class StudentStateLDVM extends ViewModel {
    private static final String Onsaveinstancestate_key_age = "age";
    private MutableLiveData<Integer> ageLD;
    private SavedStateHandle mHandle;

    //先，implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.2.0"
    public StudentStateLDVM(SavedStateHandle handle) {
        mHandle = handle;
    }


    public MutableLiveData<Integer> getAgeLD() {

        if (!mHandle.contains(Onsaveinstancestate_key_age)) {
            mHandle.set(Onsaveinstancestate_key_age, 0);
        }
        return mHandle.getLiveData(Onsaveinstancestate_key_age);
    }


    public void addAge(int age) {
        getAgeLD().setValue(getAgeLD().getValue() + age);

    }
}
