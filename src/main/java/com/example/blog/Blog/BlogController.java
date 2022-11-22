package com.example.blog.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    BlogService bservice;

    @PostMapping("addBlog")
    private ResponseEntity addBlog(@RequestBody Blog blog){
        return new ResponseEntity(bservice.addBlog(blog), HttpStatus.OK);
    }



    @PostMapping("/user/{userId}/addBlog")
    private ResponseEntity<?> addBlogwithUser(@PathVariable(value = "userId") int userID, @RequestBody Blog blog){

    return new ResponseEntity(bservice.addBlogwithUser(userID,blog),HttpStatus.OK);
    }

    @PutMapping("blog/{blogId}/comment/{commentId}")
    private ResponseEntity<?> joinblogcomment(@PathVariable(value = "blogId")int blogId,@PathVariable(value = "commentId") int commentId){

        return new ResponseEntity<>(bservice.joinbc(blogId,commentId),HttpStatus.OK);
    }

    @GetMapping("/getBlog")
    private ResponseEntity getBlog(){
        return new ResponseEntity(bservice.getBlog(),HttpStatus.OK);
    }

    @GetMapping("/getlatestBlog")
    private ResponseEntity getlatestBlog(){
        return new ResponseEntity(bservice.getlatestBlog(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteBlog/{bid}")
    private  ResponseEntity deleteBlog(@PathVariable(value = "bid")int bid){
        return new ResponseEntity(bservice.deleteBlog(bid),HttpStatus.OK);
    }



}
