package com.example.jetpackdemo.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.viewmodel.StudentVM;

public class LivedataActivity extends AppCompatActivity {
    TextView textView;

    Button button;
    StudentLDVM studentLDVM;

    ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata);
        studentLDVM = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentLDVM.class);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        layout = findViewById(R.id.layout);
        studentLDVM.getAgeLD().observeForever(new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentLDVM.addAge(1);
            }
        });

        BlankFragment blankFragment = BlankFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout, blankFragment)
                .commit();
    }
}