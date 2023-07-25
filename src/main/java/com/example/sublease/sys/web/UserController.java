package com.example.sublease.sys.web;

import com.example.sublease.exception.ResourceNotFoundException;
import com.example.sublease.sys.entity.User;
import com.example.sublease.sys.mapper.UserMapper;
import com.example.sublease.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/sys")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    // get all users
    @GetMapping("/users")
    public List<User> findAll()
    {
        return userMapper.findAll();
    }

    // create user rest API
    @PostMapping("/users")
    public Map<String, Boolean> insert(@RequestBody User user)  {
        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = userMapper.insert(user) > 0 ?
                response.put("created", Boolean.TRUE) :
                response.put("created", Boolean.FALSE);

        return response;

    }

    // get user by id rest api
    @GetMapping("/users/{id}")
    public User findById(@PathVariable String id) {

        User user = userMapper.findById(id).
                orElseThrow(() -> new ResourceNotFoundException
                        ("User not exist with id :" + id));
        return user;
    }

    // update user rest api
    @PutMapping("/users/{id}")
    public Map<String, Boolean> update(@PathVariable String id,
                                           @RequestBody User userDetails) {

        User user = userMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User not exist with id :" + id));
        userDetails.setId(id);
        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = userMapper.update(userDetails) > 0 ?
                response.put("updated", Boolean.TRUE) :
                response.put("updated", Boolean.FALSE);

        return response;
    }

    // delete user rest api
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteById(@PathVariable String id) {

        User user = userMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User not exist with id :" + id));

        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = userMapper.deleteById(user.getId()) > 0 ?
                response.put("deleted", Boolean.TRUE) :
                response.put("deleted", Boolean.FALSE);
        return response;
    }
}
