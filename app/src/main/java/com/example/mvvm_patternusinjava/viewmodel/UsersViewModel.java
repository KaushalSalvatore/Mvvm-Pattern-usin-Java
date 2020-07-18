package com.example.mvvm_patternusinjava.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_patternusinjava.apicalling.APIClient;
import com.example.mvvm_patternusinjava.apicalling.Api;
import com.example.mvvm_patternusinjava.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersViewModel extends ViewModel {
    private MutableLiveData<List<Users>> userlist ;
    public LiveData<List<Users>> grtUsers()
    {
        if(userlist == null)
        {
            userlist = new MutableLiveData<List<Users>>();
            loadUser();
        }
        return userlist;
    }
    private void loadUser()
    {
            Api api = APIClient.getClient().create(Api.class);
           Call<List<Users>> call = api.getUsers();
           call.enqueue(new Callback<List<Users>>() {
               @Override
               public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                   userlist.setValue(response.body());
                   Log.d("data","---------"+response.body().toString());

                   Log.d("data","---------");


               }

               @Override
               public void onFailure(Call<List<Users>> call, Throwable t) {
                   Log.d("error","---------"+t.toString());

               }
           });

    }
}
