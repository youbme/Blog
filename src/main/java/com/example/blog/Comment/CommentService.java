package com.example.blog.Comment;

import com.example.blog.Blog.BlogRepository;
import com.example.blog.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CommentService {

    @Autowired
    CommentRepository cRepo;
    @Autowired
    UserRepository uRepo;
    @Autowired
    BlogRepository bRepo;
    @Autowired
    CommentoDtoMapper commentoDtoMapper;


//    public ResponseEntity<?> addcomment(int userId, int blogId, Comment comment) {
//
//        Comment _comment = bRepo.findById(blogId).map(Blog-> {
//            Blog.getComment().add(comment);
//            User user = uRepo.findById(userId).get();
//            comment.setUser(user);
//            cRepo.save(comment);
//            return cRepo.save(comment);
//        }).orElseThrow(()-> new ResourceNotFoundException("NotFound"));
//
//        CommentDto commentDto = new CommentDto();
//        commentDto.setComment(comment.getComment());
//        commentDto.setCid(comment.getCid());
//
//        return new ResponseEntity<>(commentDto,HttpStatus.OK);
//    }

    public ResponseEntity getcomment() {

        List<Comment> c = cRepo.getAllComments();
       return new ResponseEntity(commentoDtoMapper.commenttodtolist(c),HttpStatus.OK);
    }

    public ResponseEntity addcomment(Comment comment) {
        return  new ResponseEntity(commentoDtoMapper.commenttodto(cRepo.save(comment)),HttpStatus.OK);
    }

    public int deletecomment(int cid) {
    int id = cid;
               cRepo.deleteById(cid);
               return id;
    }

    public ResponseEntity commentreply(int cid, int hii) {

        Set<Comment> comment = null;
         Comment commentparent = cRepo.findById(cid).get();
         Comment commentchild = cRepo.findById(hii).get();

         commentparent.getCommentreply().add(commentchild);
         cRepo.save(commentparent);

         /*Set<CommentDto> dto  =null;
         dto.add(commentchild);
         comment= commentparent.getCommentreply();
         comment.add(dto);

         CommentDto cmtdto = new CommentDto();
         cmtdto.setCid(commentparent.getCid());
         cmtdto.setComment(commentparent.getComment());
         cmtdto.setCommentreply((Set<Comment>) comment);

             commentparent.setCommentreply((Set<Comment>) commentchild);*/


    return new ResponseEntity(commentoDtoMapper.commenttodto(cRepo.save(commentparent)),HttpStatus.OK);
    }

    public ResponseEntity getcommentid(int cid) {

        Comment oc = cRepo.findById(cid).get();


        return new ResponseEntity(commentoDtoMapper.commenttodto(oc),HttpStatus.OK);
    }
}
