package com.example.demo.repository;

import com.example.demo.model.Blog;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

@Qualifier(value = "BlogRepository")
public interface BlogRepository extends JpaRepository<Blog, String> {

}
