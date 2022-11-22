package com.example.blog.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {


    @Query(
            nativeQuery = true, value = " SELECT * from blog.blog order by created_at DESC ;")
    public List<Blog> findByCreatedAt();
}
