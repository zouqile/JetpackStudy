package com.example.jetpackdemo.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.CompletionListener;
import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.ActivityRoomBinding;
import com.example.jetpackdemo.navviewmodel.StudentLDVM;

import java.util.List;

public class RoomActivity extends AppCompatActivity {


    ActivityRoomBinding binding;
    private StudentVM studentVM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room);
        studentVM = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(StudentVM.class);
        initEvent();
        studentVM.getAllLive().observe(this, new Observer<List<StudentEntity>>() {
            @Override
            public void onChanged(List<StudentEntity> studentEntities) {
                StringBuilder builder = new StringBuilder();
                for (StudentEntity entity : studentEntities) {
                    builder.append("id=" + entity.getId() + ",name=" + entity.getName() + ",age=" + entity.getAge() + "\n");
                }
                binding.textView.setText(builder.toString());
            }
        });
    }

    private void initEvent() {
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentEntity entity = new StudentEntity("test", 18);
                studentVM.insert(entity);

            }
        });

        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentVM.getAll(new CompletionListener<List<StudentEntity>>() {
                    @Override
                    public void onSuccess(List<StudentEntity> list) {
                        if (list != null && list.size() > 0) {
                            studentVM.delete(list.get(0));
                        }
                    }

                    @Override
                    public void onFail(String error) {

                    }
                });


            }
        });

        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                studentVM.getAll(new CompletionListener<List<StudentEntity>>() {
                    @Override
                    public void onSuccess(List<StudentEntity> list) {
                        if (list != null && list.size() > 0) {
                            StudentEntity entity = list.get(0);
                            entity.setName("update test");
                            studentVM.update(entity);
                        }
                    }

                    @Override
                    public void onFail(String error) {

                    }
                });

            }
        });

        binding.deleteAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentVM.deleteAll();
            }
        });
    }


}