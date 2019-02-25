package com.yuli.cloud.hybrid;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/jaxrs-v-spring/hybrid")
@SpringBootApplication
public class HybridApplication {

	public static void main(String[] args) {
		SpringApplication.run(HybridApplication.class, args);
	}

}
