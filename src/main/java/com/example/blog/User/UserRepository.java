package com.example.blog.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            nativeQuery = true, value = " SELECT * from blog.user where uid=:uid ;")
    public int deleteByuserblogcomment();
}
