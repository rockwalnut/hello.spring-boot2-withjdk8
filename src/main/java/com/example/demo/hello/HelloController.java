package com.example.demo.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.demo.dto.Health;
import com.example.demo.dto.Identify;
import com.example.demo.dto.Occupation;
import com.example.demo.dto.Prename;
import com.example.demo.dto.Product;
import com.example.demo.dto.ProductList;
import com.example.demo.dto.Relation;
import com.example.demo.dto.Religion;
import com.example.demo.dto.Result;

//import java.util.Date;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.uitility.Envi;
import com.example.demo.uitility.Token;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/cors-config")
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

    @GetMapping("/cors-config")
    @RequestMapping("/health")
    public Health health()
    {
        return new Health("ok", enviromentProperty.getBuildDate());
    } 
    

    @GetMapping("/cors-config")
    @RequestMapping("/identify")
    public List<Identify> identify()
    {
        return new Identify().ListFromTLISQL();
    } 
 
    @GetMapping("/cors-config")
    @RequestMapping("/occupation")
    public List<Occupation> occupation()
    {
        return new Occupation().ListFromTLISQL();
    } 

    @GetMapping("/cors-config")
    @RequestMapping("/prename")
    public List<Prename> prename()
    {
        return new Prename().ListFromTLISQL();
    } 


    @GetMapping("/cors-config")
    @RequestMapping("/master")
    public Result master()
    {
        Result res = new Result();

        res.setIdentifys(new Identify().ListFromTLISQL());        
        res.setPrenames(new Prename().ListFromTLISQL());      
        res.setOccupations(new Occupation().ListFromTLISQL());
        res.setRelations(new Relation().ListFromJSON());
        res.setReligions(new Religion().ListFromJSON());

        return res;
    } 

    @GetMapping("/cors-config")
    @RequestMapping("/product")
    public ProductList product()
    {
        ProductList res = new ProductList();
        res.setProducts(new Product().ListFromTLISQL());
        return res;
    } 

    @GetMapping("/cors-config")
    @RequestMapping("/token")
    public String token()
    {
        return new Token().get();
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