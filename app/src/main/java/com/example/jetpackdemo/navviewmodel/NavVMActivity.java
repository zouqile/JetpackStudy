package com.example.jetpackdemo.navviewmodel;

import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class NavVMActivity extends AppCompatActivity {

    StudentLDVM studentLDVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_vmactivity);
        studentLDVM = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentLDVM.class);
        //会报错问题原因就是在onCreate生命周期里FragmentContainerView对应的NavController未构建成功.
//        NavController controller= Navigation.findNavController(this,R.id.fragmentContainerView);
//        NavigationUI.setupActionBarWithNavController(this,controller);
        findViewById(android.R.id.content).post(new Runnable() {
            @Override
            public void run() {
                NavController controller = Navigation.findNavController(NavVMActivity.this, R.id.fragmentContainerView);
                NavigationUI.setupActionBarWithNavController(NavVMActivity.this, controller);
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController controller = Navigation.findNavController(this, R.id.fragmentContainerView);
        return controller.navigateUp();

//        return super.onSupportNavigateUp();
    }

}