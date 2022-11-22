package com.example.blog.User;

import com.example.blog.Blog.Blog;
import com.example.blog.Blog.BlogRepository;
import com.example.blog.Comment.Comment;
import com.example.blog.Comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    UsertoDtoMapper usertodtomapper;
    @Autowired
    BlogRepository blogRepo;
    @Autowired
    CommentRepository commentRepo;

    public ResponseEntity addUser(User user) {

        return new ResponseEntity(usertodtomapper.usertoDto(userRepo.save(user)), HttpStatus.OK);
    }

    public ResponseEntity getUser() {

        return new ResponseEntity(usertodtomapper.userlisttoDto(userRepo.findAll()), HttpStatus.OK);
//        List<User> userList =userRepo.findAll()
//        usertodtomapper.userlisttoDto(userList);

    }

    public ResponseEntity<?> adduserblog(int userId, int blogId) {

        Set<Blog> blogset = null;
        User user = userRepo.findById(userId).get();
        Blog blog = blogRepo.findById(blogId).get();
        blogset = user.getBlogs();
        blogset.add(blog);
        user.setBlogs((Set<Blog>) blog);
        return new ResponseEntity<>(usertodtomapper.usertoDto(userRepo.save(user)), HttpStatus.OK);

    }

    public ResponseEntity getUserId(int userId) {


        return new ResponseEntity( usertodtomapper.usertoDto( userRepo.findById(userId).get()) ,HttpStatus.OK);
    }

    public ResponseEntity deleteuser(int uid) {
        int id= uid;
        userRepo.deleteById(uid);
        return new ResponseEntity(id,HttpStatus.OK);
    }

//    public ResponseEntity deleteuserblogcomment(int uid, int bid, int cid) {
//
//        User user = userRepo.findById(uid).get();
//        Blog blog = blogRepo.findById(bid).get();
//        Comment comment = commentRepo.findById(cid).get();
//
//        blog.setComment((List<Comment>) comment);
//        user.setBlogs((Set<Blog>) blog);
//
//        return new ResponseEntity(userRepo.deleteById(3),HttpStatus.OK);
//        return new ResponseEntity(userRepo.deleteById();)
//
//    }
}