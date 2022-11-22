package com.example.blog.Blog;


import com.example.blog.Comment.Comment;
import com.example.blog.Comment.CommentRepository;
import com.example.blog.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository bRepo;
    @Autowired
    UserRepository uRepo;
    @Autowired
    CommentRepository cRepo;
    @Autowired
    BlogtoDtoMapper blogtodtomapper;

    public ResponseEntity addBlog(Blog blog) {
        return new ResponseEntity(blogtodtomapper.blogtoDto(bRepo.save(blog)), HttpStatus.OK);
    }

    public ResponseEntity addBlogwithUser(int userID, Blog blog) {

        uRepo.findById(userID).map(User->{
        User.getBlogs().add(blog);
        return bRepo.save(blog);
    }).orElseThrow(()-> new ResourceNotFoundException("Not FOund" + userID));
                return new ResponseEntity(blog,HttpStatus.OK);
}

    public ResponseEntity getBlog() {
        return new ResponseEntity(blogtodtomapper.listblogtoDto( bRepo.findAll()),HttpStatus.OK);
    }


    public ResponseEntity joinbc(int blogId, int commentId) {

        List<Comment> comment = null;
        Blog blog = bRepo.findById(blogId).get();
        Comment comments = cRepo.findById(commentId).get();
        comment = blog.getComment();
        comment.add(comments);
        blog.setComment(comment);
        return new ResponseEntity(blogtodtomapper.blogtoDto(bRepo.save(blog)),HttpStatus.OK);
    }

    public ResponseEntity getlatestBlog() {
        return new ResponseEntity(blogtodtomapper.listblogtoDto(bRepo.findByCreatedAt()),HttpStatus.OK);
    }

    public int deleteBlog(int bid) {
        int id = bid;
        bRepo.deleteById(id);
        return id;
    }
}