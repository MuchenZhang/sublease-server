package com.example.sublease.sys.mapper;

import com.example.sublease.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
@Repository
public interface UserMapper {
    List<User> findAll();

    Optional<User> findById(String id);

    int deleteById(String id);

    int insert(User user);

    int update(User user);
}
