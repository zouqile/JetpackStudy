package com.example.jetpackdemo.paging;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jetpackdemo.R;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends PagedListAdapter<Student, RecyclerAdapter.RecyclerViewHolder> {


    protected RecyclerAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paging_item, null);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Student student = getItem(position);
        holder.fillItem(student);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;

        private void fillItem(Student student) {
            tv_name.setText(student.getName());
        }

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
        }

    }


    private static DiffUtil.ItemCallback<Student> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Student>() {
                @Override
                public boolean areItemsTheSame(Student oldConcert, Student newConcert) {
                    if (TextUtils.isEmpty(oldConcert.getName()) || TextUtils.isEmpty(newConcert.getName())) {
                        return false;
                    }

                    if (oldConcert.getName().equalsIgnoreCase(newConcert.getName())) {
                        return true;
                    }

                    return false;

                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(Student oldConcert,
                                                  Student newConcert) {
                    return oldConcert.equals(newConcert);
                }
            };


}
