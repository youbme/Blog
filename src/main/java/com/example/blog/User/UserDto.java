package com.example.blog.User;

import com.example.blog.Address.Address;
import com.example.blog.Blog.BlogDto;

import java.util.List;

public class UserDto {
    private int uid;
    private String name;
    private String email;
    private List<BlogDto> blogs;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<BlogDto> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogDto> blogs) {
        this.blogs = blogs;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
