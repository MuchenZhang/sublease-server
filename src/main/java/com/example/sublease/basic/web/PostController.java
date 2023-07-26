package com.example.sublease.basic.web;

import com.example.sublease.basic.entity.Post;
import com.example.sublease.basic.mapper.PostMapper;
import com.example.sublease.basic.service.PostService;
import com.example.sublease.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/basic")
public class PostController {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostService postService;

    // get all users
    @GetMapping("/posts")
    public List<Post> findAll()
    {
        return postMapper.findAll();
    }

    // create user rest API
    @PostMapping("/posts")
    public Map<String, Boolean> insert(@RequestBody Post post)  {
        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = postMapper.insert(post) > 0 ?
                response.put("created", Boolean.TRUE) :
                response.put("created", Boolean.FALSE);

        return response;

    }

    // get user by id rest api
    @GetMapping("/posts/{id}")
    public Post findById(@PathVariable String id) {

        Post post = postMapper.findById(id).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Post not exist with id :" + id));
        return post;
    }

    // update user rest api
    @PutMapping("/posts/{id}")
    public Map<String, Boolean> update(@PathVariable String id,
                                       @RequestBody Post postDetails) {

        Post post = postMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Post not exist with id :" + id));
        postDetails.setId(id);
        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = postMapper.update(postDetails) > 0 ?
                response.put("updated", Boolean.TRUE) :
                response.put("updated", Boolean.FALSE);

        return response;
    }

    // delete user rest api
    @DeleteMapping("/posts/{id}")
    public Map<String, Boolean> deleteById(@PathVariable String id) {

        Post post = postMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Post not exist with id :" + id));

        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = postMapper.deleteById(post.getId()) > 0 ?
                response.put("deleted", Boolean.TRUE) :
                response.put("deleted", Boolean.FALSE);
        return response;
    }
}
