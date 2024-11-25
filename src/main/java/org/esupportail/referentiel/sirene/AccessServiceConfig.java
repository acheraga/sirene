package org.esupportail.referentiel.sirene;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.properties.sirene")
public class AccessServiceConfig {

	private String keyIntegration;

	private String baseUri = "";

	
	public String getBaseUri() {
		return baseUri;
	}

	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}

	
	public String getKeyIntegration() {
		return keyIntegration;
	}

	public void setKeyIntegration(String keyIntegration) {
		this.keyIntegration = keyIntegration;
	}

}
