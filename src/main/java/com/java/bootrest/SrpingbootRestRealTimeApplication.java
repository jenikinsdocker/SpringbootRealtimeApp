package com.java.bootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SrpingbootRestRealTimeApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SrpingbootRestRealTimeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SrpingbootRestRealTimeApplication.class, args);
	}

}
