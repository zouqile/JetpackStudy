package com.example.jetpackdemo.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jetpackdemo.R;

public class ViewModelActivity extends AppCompatActivity {

    TextView textView;
    TextView textView1;

    Button button;


    private StudentVM studentVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        studentVM = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentVM.class);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        button = findViewById(R.id.button);
        //创建的时候也赋值
        textView.setText(String.valueOf(studentVM.age));
        textView1.setText(String.valueOf(studentVM.age));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentVM.age++;
                textView.setText(String.valueOf(studentVM.age));
                textView1.setText(String.valueOf(studentVM.age));
            }
        });

    }
}