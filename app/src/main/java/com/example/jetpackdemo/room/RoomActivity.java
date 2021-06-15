package com.example.jetpackdemo.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.ActivityRoomBinding;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {


    ActivityRoomBinding binding;

    StudentDao studentDao;
    StudentDatabase studentDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room);
        //allowMainThreadQueries,测试功能允许主线程，使用可以用callback方式。回调回主线程
        studentDatabase = Room.databaseBuilder(this, StudentDatabase.class, "student_databse")
                .allowMainThreadQueries().build();
        studentDao = studentDatabase.getStudentDao();
        showAllStudent();
        initEvent();

    }

    private void initEvent() {
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentEntity entity = new StudentEntity("test", 18);
                studentDao.insert(entity);
                showAllStudent();

            }
        });

        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<StudentEntity> list = studentDao.getAll();
                if (list != null && list.size() > 0) {
                    studentDao.delete(list.get(0));
                }
                showAllStudent();
            }
        });

        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<StudentEntity> list = studentDao.getAll();
                if (list != null && list.size() > 0) {
                    StudentEntity entity = list.get(0);
                    entity.setName("update test");
                    studentDao.update(entity);
                }
                showAllStudent();
            }
        });

        binding.deleteAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentDao.deleteAll();
                showAllStudent();
            }
        });
    }


    private void showAllStudent() {
        List<StudentEntity> list = studentDao.getAll();

        StringBuilder builder = new StringBuilder();
        for (StudentEntity entity : list) {
            builder.append("id=" + entity.getId() + ",name=" + entity.getName() + ",age=" + entity.getAge());
        }
        binding.textView.setText(builder.toString());
    }

}