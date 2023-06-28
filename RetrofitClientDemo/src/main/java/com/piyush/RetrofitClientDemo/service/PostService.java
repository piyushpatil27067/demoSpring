package com.piyush.RetrofitClientDemo.service;

import com.piyush.RetrofitClientDemo.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<Post> fetchPosts();
    public Post fetchPostById(int id);
    public String deleteById(int id);
    public String insert(Post post);
    public String update(int id, Post post);
}
