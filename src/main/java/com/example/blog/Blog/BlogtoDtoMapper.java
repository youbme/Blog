package com.example.blog.Blog;

import com.example.blog.Comment.CommentoDtoMapper;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = CommentoDtoMapper.class)
public interface BlogtoDtoMapper {

    BlogDto blogtoDto ( Blog blog);
    List<BlogDto> listblogtoDto(List<Blog> blog);

    Blog  BlogDtotoBlog (BlogDto blogdto);


}
