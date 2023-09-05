package org.esupportail.referentiel.sirene;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
//import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(servers = {
		@Server(url = "${app.openApi.server-url:/}") }, info = @Info(title = "${app.openApi.server-title}",
				version = "${app.openApi.server-version}"))
public class OpenApiConfig {
	
	@Bean
	public GroupedOpenApi sihamGroup() {
		return GroupedOpenApi.builder().group("sirene").packagesToScan("org.esupportail.referentiel.sirene.client.rest").build();
	}

}
