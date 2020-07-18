package com.example.mvvm_patternusinjava.apicalling;

import com.example.mvvm_patternusinjava.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("b00bdb30?count=10&key=af63fef0")
    Call<List<Users>> getUsers();
}
