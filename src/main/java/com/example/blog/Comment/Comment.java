package com.example.blog.Comment;

import com.example.blog.User.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany
    private Set<Comment> commentreply;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }


    public Set<Comment> getCommentreply() {
        return commentreply;
    }

    public void setCommentreply(Set<Comment> commentreply) {
        this.commentreply = commentreply;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
