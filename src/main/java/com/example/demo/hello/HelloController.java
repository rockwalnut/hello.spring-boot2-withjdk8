package com.example.demo.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.demo.dto.Health;

//import java.util.Date;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.uitility.Envi;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class HelloController {

    //private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private Envi enviromentProperty;
    
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

    @RequestMapping("/health")
    public Health health()
    {
        return new Health("ok", new Date().toString()); //  enviromentProperty.getBuildDate());
    } 

    //after app is start
	/*@PostConstruct
	public void initialize() throws IOException {
		log.info(">>>>> Initialize <<<<<");
		boolean localStorageExists = Files.exists(Paths.get(property.getStoragePath()));
		log.info(">>>>> Storage :{} exists :{}", property.getStoragePath(), localStorageExists);
		if (!localStorageExists) {
			Files.createDirectory(Paths.get(property.getStoragePath()));
		}
		log.info(">>>>> Local Storage :{}", Paths.get(property.getStoragePath()).toAbsolutePath());
	}*/

}