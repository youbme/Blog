package com.example.blog.Blog;

import com.example.blog.Comment.Comment;
import com.example.blog.Comment.CommentDto;

import java.util.Date;
import java.util.List;

public class BlogDto {

    private int bid;
    private Date createdAt;
    private String createdBy;
    private String content;

    List<CommentDto> comment;


    public List<CommentDto> getComment() {
        return comment;
    }

    public void setComment(List<CommentDto> comment) {
        this.comment = comment;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
