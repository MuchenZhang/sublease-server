package com.example.sublease.basic.service;

import com.example.sublease.basic.entity.Post;
import com.example.sublease.basic.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public List<Post> findAll() {
        return postMapper.findAll();
    }

    public Optional<Post> findById(String id) {
        return postMapper.findById(id);
    }

    public int insert(Post post) {
        String id = UUID.randomUUID().toString();
        post.setId(id);
        return postMapper.insert(post);
    }

    public int update(Post post) {
        return postMapper.update(post);
    }

    public int deleteById(String id) {
        return postMapper.deleteById(id);
    }
}
