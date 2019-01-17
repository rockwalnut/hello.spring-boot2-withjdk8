package com.example.demo.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BlogService {

    
	private static final Logger log = LoggerFactory.getLogger(BlogService.class);

    @Autowired // (required=true)
    @Qualifier(value = "BlogRepository")
    private BlogRepository blogRepository;
    

    public Blog get(String id)
    {
       //log.info(id); 

       Optional<Blog> blog = blogRepository.findById(id);
       
       //log.debug(" " + blog.isPresent()); 

       return blog.get();
    }

}