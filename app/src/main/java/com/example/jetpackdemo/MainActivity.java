package com.example.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.databinding.DatabindingActivity;
import com.example.jetpackdemo.lifecycles.LifeCyclesActivity;
import com.example.jetpackdemo.livedata.LivedataActivity;
import com.example.jetpackdemo.navigation.NavigationActivity;
import com.example.jetpackdemo.navviewmodel.NavVMActivity;
import com.example.jetpackdemo.room.RoomActivity;
import com.example.jetpackdemo.savestate.SaveStateActivity;
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

    public void savestate(View view) {
        Intent intent = new Intent(MainActivity.this, SaveStateActivity.class);
        startActivity(intent);
    }

    public void navigation(View view) {
        Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
        startActivity(intent);
    }

    public void navvm(View view) {
        Intent intent = new Intent(MainActivity.this, NavVMActivity.class);
        startActivity(intent);
    }

    public void lifecycles(View view) {
        Intent intent = new Intent(MainActivity.this, LifeCyclesActivity.class);
        startActivity(intent);
    }

    public void room(View view) {
        Intent intent = new Intent(MainActivity.this, RoomActivity.class);
        startActivity(intent);
    }





}