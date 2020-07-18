package com.example.mvvm_patternusinjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvvm_patternusinjava.R;
import com.example.mvvm_patternusinjava.model.Users;
import com.example.mvvm_patternusinjava.viewholder.UserViewHolder;

import java.util.List;

public class Useradaper extends RecyclerView.Adapter<UserViewHolder> {
    List<Users> usersList;
    public Useradaper(List<Users> usersList)
    {
        this.usersList = usersList;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem_view,parent,false);
        return new UserViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Users data = usersList.get(position);
        holder.setText(data);
    }


    @Override
    public int getItemCount() {
        return usersList.size();
    }

}
