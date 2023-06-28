package com.piyush.RetrofitClientDemo.controller;

import com.piyush.RetrofitClientDemo.model.Post;
import com.piyush.RetrofitClientDemo.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

    @Resource
    private PostService postService;

    @GetMapping("/products")
    public List<Post> fetchPosts(){
        return postService.fetchPosts();
    }

    @GetMapping("/products/{id}")
    public Post fetchPost(@PathVariable("id") int id){
        return postService.fetchPostById(id);
    }

    @DeleteMapping("/products/{id}")
    public String deletePost(@PathVariable("id") int id){
        return postService.deleteById(id);
    }

    @PostMapping("/products")
    public String insert(@RequestBody Post post) {
        return postService.insert(post); }

    @PutMapping("/products/{id}")
    public String update(@PathVariable("id") int id, @RequestBody Post post) {
        return postService.update(id, post); }
}
