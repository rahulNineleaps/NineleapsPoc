package com.rahul.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

/*
 * @SpringBootConfiguration
 * 
 * @EnableAutoConfiguration
 * 
 * @ComponentScan(excludeFilters={@Filter(type=CUSTOM,
 * classes={TypeExcludeFilter.class}),
 */
@EnableEurekaServer


/* @Import(value={EurekaServerMarkerConfiguration.class}) */


public class DiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}

}
/*spring.application.name=nineleaps-registry
server.port=8761
#server.debug=true
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false*/