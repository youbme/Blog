package com.example.blog.Comment;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentoDtoMapper {

    CommentDto commenttodto(Comment comment);
    List<CommentDto> commenttodtolist(List<Comment> comment);
    Comment dtotocomment(CommentDto commentDto);
}
