package com.example.jetpackdemo.databinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.example.jetpackdemo.R;

public class DatabindingActivity extends AppCompatActivity {



    ActivityDatabindingBinding binding;
    StudentLDVM studentLDVM;

    StudentOBVM studentBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        studentLDVM = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentLDVM.class);
        binding.setData(studentLDVM);
        binding.setLifecycleOwner(this);
        //

        //     这个直接再xml里面就可以了
//        studentLDVM.getAgeLD().observeForever(new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.textView.setText(String.valueOf(integer));
//            }
//        });


        //------------------------------
        studentBind = new StudentOBVM();
        binding.setStudent(studentBind);
        binding.setLifecycleOwner(this);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentLDVM.addAge(1);
                studentBind.setName("test");
            }
        });
    }


}