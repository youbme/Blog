package com.example.blog.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class CommentController {

    @Autowired
    CommentService cservice;
//
//    @PostMapping("/user/{userId}/blog/{blogId}/addcomment")
//    private ResponseEntity<?> addcomment(@PathVariable(value = "userId") int userId,
//                           @PathVariable(value = "blogId") int blogId,
//                           @RequestBody Comment comment){
//        return new ResponseEntity<>(cservice.addcomment(userId,blogId,comment), HttpStatus.OK);
//
//    }

    @PostMapping("/addComment")
    private ResponseEntity getcomment(@RequestBody Comment comment){
        return new ResponseEntity(cservice.addcomment(comment),HttpStatus.OK);
    }
    @GetMapping("/getComment")
    private ResponseEntity addcomment(){
        return  new ResponseEntity(cservice.getcomment(),HttpStatus.OK);
    }


    
    @GetMapping("/getComment/{cid}")
    private ResponseEntity getcommentid(@PathVariable(value = "cid") int cid){
        return new ResponseEntity(cservice.getcommentid(cid),HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{cid}")
    private ResponseEntity deletecomment(@PathVariable (value = "cid") int cid){
        return new ResponseEntity(cservice.deletecomment(cid),HttpStatus.OK);
    }
//    @PutMapping("/blog/{bid}/comment/{cid}")
//    private ResponseEntity blogcomment(@RequestParam int bid, int cid){
//        return new ResponseEntity(())
//    }

    @PutMapping("/comment/{cid}/reply/{crid}")
    private ResponseEntity replycomment(@PathVariable (value = "cid") int cid,
                                        @PathVariable(value = "crid") int crid   )
        {
            return new ResponseEntity(cservice.commentreply(cid, crid), HttpStatus.OK);
        }
}
