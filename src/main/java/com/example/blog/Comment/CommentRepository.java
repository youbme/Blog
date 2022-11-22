package com.example.blog.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query(nativeQuery = true, value = "select * from comment where cid not in(select commentreply_cid from comment_commentreply)")
    List<Comment> getAllComments();

}
