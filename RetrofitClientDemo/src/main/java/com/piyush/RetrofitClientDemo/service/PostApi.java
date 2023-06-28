package com.piyush.RetrofitClientDemo.service;

import com.piyush.RetrofitClientDemo.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface PostApi {
    @POST("/products")
    Call<String> insert(@Body Post post);

    @GET("/products")
    Call<List<Post>> fetchPosts();

    @GET("/products/{id}")
    Call<Post> fetchPostById(@Path("id") int id);

    @PUT("/products/{id}")
    Call<String> update(@Path("id")int id, @Body Post post);

    @DELETE("/products/{id}")
    Call<String> deleteById(@Path("id") int id);
}