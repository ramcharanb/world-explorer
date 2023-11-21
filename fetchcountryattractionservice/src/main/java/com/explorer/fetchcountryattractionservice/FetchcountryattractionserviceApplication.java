package com.explorer.fetchcountryattractionservice;


import com.explorer.fetchcountryattractionservice.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.explorer.fetchcountryattractionservice.filter.*;


@SpringBootApplication
public class FetchcountryattractionserviceApplication {


	@Bean
	public FilterRegistrationBean JwtFilter() {
		final FilterRegistrationBean registrationBean=new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FetchcountryattractionserviceApplication.class, args);
	}

}
