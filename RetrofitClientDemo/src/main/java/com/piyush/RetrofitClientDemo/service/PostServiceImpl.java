package com.piyush.RetrofitClientDemo.service;

import com.piyush.RetrofitClientDemo.model.Post;
import com.piyush.RetrofitClientDemo.util.RetrofitUtil;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostServiceImpl implements PostService{
    private Retrofit retrofit;
    private PostApi postApi;

    public PostServiceImpl() {
        retrofit = RetrofitUtil.getRetrofitInstance();
        postApi = retrofit.create(PostApi.class);
    }

    @Override
    public List<Post> fetchPosts() {
        List<Post> postResponse = new ArrayList<>();
        Call<List<Post>> fetchPostCall =postApi.fetchPosts();
        try {
            Response<List<Post>> response = fetchPostCall.execute();  //enqueue method is used when we need asynchronus communication, for sync communication use execute.
            if (response.isSuccessful() && response.body() != null)
            {
                postResponse=response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postResponse;
    }

    @Override
    public Post fetchPostById(int id){
        Post post = null;
        Call<Post> postCall = postApi.fetchPostById(id);

        try{
           Response<Post> response = postCall.execute() ;
           if(response.isSuccessful() && response.body() != null)
           {
               post = response.body();
           }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public String deleteById(int id){
        String post = null;
        Call<String> postCall = postApi.deleteById(id);
        try {
            Response response = postCall.execute();
            post = (String) response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public String insert(Post post){
        String newPost = null;
        Call<String> postCall = postApi.insert(post);
        try {
            Response<String> response = postCall.execute();

            if(response.isSuccessful() && response.body() != null) {
                newPost = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newPost;
    }

    @Override
    public String update(int id, Post post){
        String newPost = null;
        Call<String> postCall = postApi.update(id, post);
        try {
            Response<String> response = postCall.execute();

            if(response.isSuccessful() && response.body() != null) {
                newPost = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newPost;
    }
}

