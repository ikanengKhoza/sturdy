package com.example.demo.repositories;

import com.example.demo.models.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogsRepository extends JpaRepository <Blogs, Long> {
}
