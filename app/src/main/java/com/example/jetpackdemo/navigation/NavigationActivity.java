package com.example.jetpackdemo.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.R;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        //会报错问题原因就是在onCreate生命周期里FragmentContainerView对应的NavController未构建成功.
//        NavController controller= Navigation.findNavController(this,R.id.fragmentContainerView);
//        NavigationUI.setupActionBarWithNavController(this,controller);
        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(NavigationActivity.this, R.id.fragmentContainerView);
                NavigationUI.setupActionBarWithNavController(NavigationActivity.this, controller);
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