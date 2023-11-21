package com.explorer.favservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.explorer.favservice.filter.JwtFilter;


@SpringBootApplication
public class FavServiceApplication {


	@Bean
	public FilterRegistrationBean JwtFilter() {
		final FilterRegistrationBean registrationBean=new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FavServiceApplication.class, args);
	}

}
