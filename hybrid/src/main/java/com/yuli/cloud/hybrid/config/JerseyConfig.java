//: com.yuli.cloud.hybrid.config.JerseyConfig.java


package com.yuli.cloud.hybrid.config;


import com.yuli.cloud.hybrid.HybridApplication;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// scan the resources package for our resources
		packages(HybridApplication.class.getPackage().getName() + ".resource");
	}

}///:~