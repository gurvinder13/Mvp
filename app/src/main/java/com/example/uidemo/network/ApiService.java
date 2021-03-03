package com.example.uidemo.network;


import com.example.uidemo.model.PostResponse;
import com.example.uidemo.model.UserResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    /**
     *   Api Call
     */
    @GET(ApiEndPoints.POST)
    Observable<List<PostResponse>> getPost();
    @GET(ApiEndPoints.USER)
    Observable<List<UserResponse>> getUser();
}

