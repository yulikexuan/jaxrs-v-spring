//: com.yuli.cloud.jaxrs.JaxrsApp.java


package com.yuli.cloud.jaxrs;


import com.yuli.cloud.domain.repositories.DefaultStormtrooperRepository;
import com.yuli.cloud.domain.repositories.IStormtrooperRepository;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/jaxrs-v-spring/jaxrs")
public class JaxrsApp extends ResourceConfig {

	public JaxrsApp() {

		// scan the resources package for our resources
		packages(getClass().getPackage().getName() + ".resources");

		// use @Inject to bind the StormtrooperDao
		register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(stormtrooperRepository()).to(IStormtrooperRepository.class);
			}
		});
	}

	private IStormtrooperRepository stormtrooperRepository() {
		return new DefaultStormtrooperRepository();
	}

}///:~