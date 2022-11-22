package com.example.blog.User;

import com.example.blog.Blog.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userservice;

    @PostMapping("/addUser")
    private ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity(userservice.addUser(user), HttpStatus.OK);
    }

    @GetMapping("/getUser")
    private ResponseEntity<?> getUser(){
        return new ResponseEntity(userservice.getUser(),HttpStatus.OK);
    }

    @GetMapping("/getUser/{userId}")
    private ResponseEntity getUserId(@PathVariable (value = "userId")int userId){
        return new ResponseEntity(userservice.getUserId(userId),HttpStatus.OK);
    }
    @PutMapping("/user/{userId}/blog/{blogId}")
    private ResponseEntity<?> adduserblog(@PathVariable(value = "userId")int userId,
                                          @PathVariable(value = "blogId")int blogId){
        return new ResponseEntity<>(userservice.adduserblog(userId, blogId),HttpStatus.OK);
    }
    @DeleteMapping("/deleteUser/{uid}")
    private ResponseEntity deleteuser(@PathVariable (value = "uid") int uid){
        return new ResponseEntity(userservice.deleteuser(uid),HttpStatus.OK);
    }
//    @DeleteMapping("/deleteUser/{uid}/blog/{bid}/comment/{cid}")
//    private ResponseEntity deleteuserblogcomment(@PathVariable (value = "uid") int uid,
//                                                 @PathVariable (value = "bid") int bid,
//                                                 @PathVariable (value = "cid") int cid)
//    {
//        return new ResponseEntity(userservice.deleteuserblogcomment(uid, bid, cid),HttpStatus.OK);
//    }

}
