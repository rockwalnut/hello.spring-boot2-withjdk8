package com.example.demo.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//import java.util.Date;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
	@Autowired
	private BlogService blogService;

    @RequestMapping("/hello")
    public Blog index() {
     
        /*List<Blog> blogs = new ArrayList<>(Arrays.asList(
            new Blog("LIP001", "XOXO Lipstick", 1),
            new Blog("BRO001", "NYX Brush On Palette", 1),
            new Blog("THX001", "Sun Flower SPF15", 1)
        ));*/
         
        String id = "uuid-01";
        return blogService.get(id);
     
        //return "Hello World with Spring Boot 2 at " + new Date().toString();
    }

}