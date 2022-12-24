package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserviceApplication.class, args);
	
	}
	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(
	ReactiveDiscoveryClient rdc, 
	DiscoveryLocatorProperties dlp)
	{
	return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}
	/*@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder)
	{
	return builder.routes()
	.route(r->r.path("/membres/**").uri("lb://MEMBRE-SERVICE"))
	.route(r->r.path("/publications/**").uri("lb://PUBLICATION-SERVICE"))
	.build();
	}*/






}

