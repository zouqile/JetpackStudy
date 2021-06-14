package com.example.jetpackdemo.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jetpackdemo.R;

public class LifeCyclesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycles);
        MyChronometer chronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);
    }
}