package com.example.jetpackdemo.paging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PositionalDataSource;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.ActivityPagingBinding;

import java.util.ArrayList;
import java.util.List;

public class PagingActivity extends AppCompatActivity {

    private ActivityPagingBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_paging);
        init();
    }

    private void init() {
        RecyclerAdapter adapter = new RecyclerAdapter();
        dataBinding.recyclerView.setAdapter(adapter);
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        StudentDataSourceFactory factory=new StudentDataSourceFactory();
        LiveData<PagedList<Student>> convertList=new LivePagedListBuilder<>(factory, 20).build();
        convertList.observeForever(new Observer<PagedList<Student>>() {
            @Override
            public void onChanged(PagedList<Student> students) {
                adapter.submitList(students);
            }
        });

    }




    private static  class  StudentDataSourceFactory  extends DataSource.Factory<Integer, Student> {

        @NonNull
        @Override
        public DataSource<Integer, Student> create() {
            return new StudentDataSource();
        }
    }


    private static  class  StudentDataSource extends PositionalDataSource<Student>
    {

        @Override
        public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Student> callback) {
            callback.onResult(fetchItems(0, 20), 0, 100);
            
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Student> callback) {
            callback.onResult(fetchItems(params.startPosition, params.loadSize));
        }
    }


    private static List<Student> fetchItems(int startPosition, int pageSize) {
        List<Student> list = new ArrayList<>();
        for (int i = startPosition; i < startPosition + pageSize; i++) {
            Student concert = new Student();
            concert.setAge(i);
            concert.setName(String.valueOf(i));
            list.add(concert);
        }
        return list;
    }

}