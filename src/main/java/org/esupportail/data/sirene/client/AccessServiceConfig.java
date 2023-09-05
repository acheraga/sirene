package org.esupportail.data.sirene.client;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.properties.sirene")
public class AccessServiceConfig {

	final private transient Logger logger = LoggerFactory.getLogger(this.getClass());

	private transient long duration = 604800;

	private LocalDateTime tokenCreatedDateTime;

	private String svcAcountLogin;

	private String svcAcountPassword;

	private String keys;

	private String tokenUrl = "https://api.insee.fr/token";

	private String baseUri = "https://api.insee.fr/entreprises/sirene/V3";

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public LocalDateTime getTokenCreatedDateTime() {
		return tokenCreatedDateTime;
	}

	public void setTokenCreatedDateTime(LocalDateTime tokenCreatedDateTime) {
		this.tokenCreatedDateTime = tokenCreatedDateTime;
	}

	public String getSvcAcountLogin() {
		return svcAcountLogin;
	}

	public void setSvcAcountLogin(String svcAcountLogin) {
		this.svcAcountLogin = svcAcountLogin;
	}

	public String getSvcAcountPassword() {
		return svcAcountPassword;
	}

	public void setSvcAcountPassword(String svcAcountPassword) {
		this.svcAcountPassword = svcAcountPassword;
	}

	public String getKeys() {
		this.keys = svcAcountLogin + ":" + svcAcountPassword;
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}

	public Logger getLogger() {
		return logger;
	}

}
