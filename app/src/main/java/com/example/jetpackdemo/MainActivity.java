package com.example.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.databinding.DatabindingActivity;
import com.example.jetpackdemo.livedata.LivedataActivity;
import com.example.jetpackdemo.viewmodel.ViewModelActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewmodel(View view) {
        Intent intent = new Intent(MainActivity.this, ViewModelActivity.class);
        startActivity(intent);
    }

    public void livedata(View view) {
        Intent intent = new Intent(MainActivity.this, LivedataActivity.class);
        startActivity(intent);
    }

    public void dataBinding(View view) {
        Intent intent = new Intent(MainActivity.this, DatabindingActivity.class);
        startActivity(intent);
    }


}