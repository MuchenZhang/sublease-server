package com.example.sublease.sys.entity;

import com.example.sublease.basic.entity.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Data
@Getter
@Setter
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String pwd;
    private String myPosts;
    private String starredPosts;

    public User() {
        this.id = UUID.randomUUID().toString();
    }
    public User(String id,String firstName,
                String lastName, String email, String pwd,
                String myPosts, String starredPosts) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pwd = pwd;
        this.myPosts = myPosts;
        this.starredPosts = starredPosts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(String myPosts) {
        this.myPosts = myPosts;
    }

    public String getStarredPosts() {
        return starredPosts;
    }

    public void setStarredPosts(String starredPosts) {
        this.starredPosts = starredPosts;
    }
}
