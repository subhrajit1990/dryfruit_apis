package com.manager.dryfruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author subhrajit
 *
 */
@SpringBootApplication(scanBasePackages = "com.manager.*")
@EnableJpaRepositories(basePackages = "com.manager.*")
@ComponentScan(basePackages ="com.manager.*")
@EntityScan(basePackages = "com.manager.*")
@EnableSwagger2
public class DryfruitApplication {

	public static void main(String[] args) {
		SpringApplication.run(DryfruitApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://agrofinesapi.herokuapp.com/");
			}
		};
	}

}
