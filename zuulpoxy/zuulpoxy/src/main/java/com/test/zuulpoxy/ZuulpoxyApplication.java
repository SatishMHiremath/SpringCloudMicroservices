package com.test.zuulpoxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulpoxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulpoxyApplication.class, args);
	}
	
//	@Bean
//	public CustomFilter getFilter() {
//		return new CustomFilter();
//	}

}
