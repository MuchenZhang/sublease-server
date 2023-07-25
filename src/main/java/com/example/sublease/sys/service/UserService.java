package com.example.sublease.sys.service;

import com.example.sublease.sys.entity.User;
import com.example.sublease.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public Optional<User> findById(String id) {
        return userMapper.findById(id);
    }

    public void insert(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void deleteById(String id) {
        userMapper.deleteById(id);
    }
}
