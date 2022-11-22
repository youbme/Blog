package com.example.blog.User;

import com.example.blog.Blog.BlogtoDtoMapper;
import com.example.blog.Comment.CommentoDtoMapper;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = BlogtoDtoMapper.class)
public interface UsertoDtoMapper {

    UserDto usertoDto(User user);
    UserDto useroptionaltoDto(Optional<User> user);

    List<UserDto> userlisttoDto(List<User> user);
}
