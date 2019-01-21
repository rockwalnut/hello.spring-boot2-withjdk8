package com.example.demo.config;

import javax.sql.DataSource;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@ComponentScan(basePackages = {
     "com.example.demo.model",
     "com.example.demo.controller",
     "com.example.demo.config",
     "com.example.demo.service",
     "com.example.demo.repository"
})

@EnableJpaRepositories("com.example.demo.repository")
        
// @PropertySource("file:application.properties")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class AppConfig {
	//private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

	//@Bean
	//@Primary
	//@ConfigurationProperties(prefix = "spring.datasource")
    
    /*public DataSource mainDataSource() {
		log.info(">>>>> DataSource Created <<<<<");
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}*/


	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
			
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("cors-config").allowedOrigins("*");
            }
        };
    }


}
