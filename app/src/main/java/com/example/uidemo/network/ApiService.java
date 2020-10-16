package com.example.uidemo.network;


import com.example.uidemo.model.ArticleResponse;
import com.example.uidemo.network.ApiEndPoints;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    /**
     * Article  Api Call
     */
    @GET(ApiEndPoints.ARTICLE)
    Observable<ArticleResponse> getArticle(@Query("sources") String sources, @Query("apiKey") String apiKey);

}

