package com.example.mvvm_patternusinjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.example.mvvm_patternusinjava.R;
import com.example.mvvm_patternusinjava.adapter.Useradaper;
import com.example.mvvm_patternusinjava.model.Users;
import com.example.mvvm_patternusinjava.viewmodel.UsersViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Useradaper useradaper;
    List<Users> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Log.d("andriod 9","--------");

        }
        userdata();
    }
    private void userdata()
    {
        UsersViewModel usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        usersViewModel.grtUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> usersList) {
                useradaper = new Useradaper(usersList);
                recyclerView.setAdapter(useradaper);
            }
        });
    }
}