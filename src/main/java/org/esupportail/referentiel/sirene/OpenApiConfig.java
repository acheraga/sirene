package org.esupportail.referentiel.sirene;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
//import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(servers = {
		@Server(url = "${app.openApi.server-url:/}") }, info = @Info(title = "${app.openApi.server-title}",
				version = "${app.openApi.server-version}"))
public class OpenApiConfig implements WebMvcConfigurer {
	
	@Bean
	public GroupedOpenApi sihamGroup() {
		return GroupedOpenApi.builder().group("sirene").packagesToScan("org.esupportail.referentiel.sirene.client.rest").build();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("+++++++++++++++++++++++++++++++");
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
	}

}
