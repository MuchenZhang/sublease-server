package com.example.sublease.basic.mapper;

import com.example.sublease.basic.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface PostMapper {
    List<Post> findAll();

    Optional<Post> findById(String id);

    int deleteById(String id);

    int insert(Post post);

    int update(Post post);
}
