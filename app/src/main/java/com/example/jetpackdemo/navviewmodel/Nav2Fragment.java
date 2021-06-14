package com.example.jetpackdemo.navviewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.FragmentNav1Binding;
import com.example.jetpackdemo.databinding.FragmentNav2Binding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class Nav2Fragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_nav2, container, false);
        StudentLDVM viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(StudentLDVM.class);

        //跟Activity的不同
        FragmentNav2Binding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nav2, container, false);
        binding.setData(viewModel);
        binding.setLifecycleOwner(getActivity());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addAge(1);
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.nav1Fragment);
            }
        });
        return binding.getRoot();
    }
}