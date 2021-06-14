package com.example.jetpackdemo.savestate;

import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.ActivitySaveStateBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

public class SaveStateActivity extends AppCompatActivity {
    private static final String Onsaveinstancestate_key_age = "age";


    ActivitySaveStateBinding binding;
//    StudentLDVM studentLDVM;

    StudentStateLDVM studentStateLDVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_save_state);
        studentStateLDVM = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(),this)).get(StudentStateLDVM.class);
        binding.setData(studentStateLDVM);
        binding.setLifecycleOwner(this);
        //        studentLDVM = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentLDVM.class);
//        if (savedInstanceState != null && savedInstanceState.containsKey(Onsaveinstancestate_key_age)) {
//            studentLDVM.getAgeLD().setValue(savedInstanceState.getInt(Onsaveinstancestate_key_age));
//        }
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                studentLDVM.addAge(1);
                studentStateLDVM.addAge(1);
            }
        });
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(Onsaveinstancestate_key_age, studentLDVM.getAgeLD().getValue());
//
//    }
}