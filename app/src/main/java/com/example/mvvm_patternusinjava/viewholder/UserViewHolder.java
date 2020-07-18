package com.example.mvvm_patternusinjava.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_patternusinjava.R;
import com.example.mvvm_patternusinjava.model.Users;
import com.squareup.picasso.Picasso;


public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView user_name,user_id,user_email,user_gender,user_ipaddress;
    ImageView user_image;
    Context context;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        user_name = itemView.findViewById(R.id.user_name);
        user_id = itemView.findViewById(R.id.user_id);
        user_email = itemView.findViewById(R.id.user_email);
        user_gender = itemView.findViewById(R.id.user_gender);
        user_ipaddress = itemView.findViewById(R.id.user_ipaddress);
        user_image = itemView.findViewById(R.id.user_image);



    }
    public void setText(Users users){
        user_name.setText(users.getFirstName()+ "-" +users.getLastName());
        user_id.setText(users.getId());
        user_email.setText(users.getEmail());
        user_gender.setText(users.getGender());
        user_ipaddress.setText(users.getIpAddress());
                Picasso.get().load(users.getImage()).fit().centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(user_image);

    }


}
