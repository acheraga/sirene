package org.esupportail.data.sirene.client.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.esupportail.data.sirene.client.AccessServiceConfig;
import org.esupportail.data.sirene.entreprise.client.api.EtablissementApi;
import org.esupportail.data.sirene.entreprise.client.api.InformationsApi;
import org.esupportail.data.sirene.entreprise.client.invoker.ApiClient;
import org.esupportail.data.sirene.entreprise.client.invoker.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class AccessService {
	
	final private transient Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccessServiceConfig accessServiceConfig;


	private ApiClient defaultClient = Configuration.getDefaultApiClient();

	JsonNode jsonToken;

	protected synchronized String getToken() throws IOException, InterruptedException {
//
//		if (jsonToken != null) {
//			logger.debug("TOKEN expires_in " +jsonToken.get("expires_in"));;
//			JsonNode token_expire = jsonToken.get("expires_in");
//			
//			if (token_expire.asInt() > 0) {
//				return jsonToken.get("access_token").asText();
//			}
//
//		}

		HashMap<String, String> parameters = new HashMap<>();
		parameters.put("grant_type", "client_credentials");
		String form = parameters.keySet().stream()
				.map(key -> key + "=" + URLEncoder.encode(parameters.get(key), StandardCharsets.UTF_8))
				.collect(Collectors.joining("&"));

		String encoding = Base64.getEncoder().encodeToString(accessServiceConfig.getKeys().getBytes());
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(accessServiceConfig.getTokenUrl()))
				.headers("Content-Type", "application/x-www-form-urlencoded", "Authorization", "Basic " + encoding)
				.POST(BodyPublishers.ofString(form)).build();
		HttpResponse<?> response = client.send(request, BodyHandlers.ofString());

		ObjectMapper mapper = new ObjectMapper();
		jsonToken = mapper.readTree(response.body().toString());

		logger.debug("TOKEN GENERATE INFO" + response.statusCode() + " : " + jsonToken.toPrettyString());

		Assert.notNull(jsonToken, "dosent be null");
		return jsonToken.get("access_token").asText();

	}

	protected EtablissementApi getEtablissementApi() {
		defaultClient.updateBaseUri(accessServiceConfig.getBaseUri());

		defaultClient.setRequestInterceptor(builder -> {
			// builder.setHeader("Authorization", "Bearer " +
			// "8a31ed5d-6f47-3928-9ae2-ec09eb855add");
			try {
				builder.setHeader("Authorization", "Bearer " + getToken());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		EtablissementApi api = new EtablissementApi(defaultClient);
		return api;
	}

	InformationsApi getInformationsApi() {
		defaultClient.updateBaseUri(accessServiceConfig.getBaseUri());

		defaultClient.setRequestInterceptor(builder -> {
			// builder.setHeader("Authorization", "Bearer " +
			// "8a31ed5d-6f47-3928-9ae2-ec09eb855add");
			try {
				builder.setHeader("Authorization", "Bearer " + getToken());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		InformationsApi api = new InformationsApi(defaultClient);
		return api;

	}

	public AccessServiceConfig getAccessServiceConfig() {
		return accessServiceConfig;
	}

	public void setAccessServiceConfig(AccessServiceConfig accessServiceConfig) {
		this.accessServiceConfig = accessServiceConfig;
	}

	
	

}
