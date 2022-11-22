package com.example.blog.Comment;

import java.util.Set;

public class CommentDto {

    private int cid;
    private String comment;
    private Set<CommentDto> commentreply;

    public Set<CommentDto> getCommentreply() {
        return commentreply;
    }

    public void setCommentreply(Set<CommentDto> commentreply) {
        this.commentreply = commentreply;
    }

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


}
