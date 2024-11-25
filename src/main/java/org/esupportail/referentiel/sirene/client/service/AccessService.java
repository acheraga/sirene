package org.esupportail.referentiel.sirene.client.service;

import org.esupportail.data.sirene.entreprise.client.api.EtablissementApi;
import org.esupportail.data.sirene.entreprise.client.api.InformationsApi;
import org.esupportail.data.sirene.entreprise.client.invoker.ApiClient;
import org.esupportail.data.sirene.entreprise.client.invoker.Configuration;
import org.esupportail.referentiel.sirene.AccessServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccessService {
	
	final private transient Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccessServiceConfig accessServiceConfig;


	private ApiClient defaultClient = Configuration.getDefaultApiClient();


	protected EtablissementApi getEtablissementApi() {
		defaultClient.updateBaseUri(accessServiceConfig.getBaseUri());

		defaultClient.setRequestInterceptor(builder -> {
			builder.setHeader("X-INSEE-Api-Key-Integration", accessServiceConfig.getKeyIntegration());
		});
		EtablissementApi api = new EtablissementApi(defaultClient);
		return api;
	}

	InformationsApi getInformationsApi() {
		defaultClient.updateBaseUri(accessServiceConfig.getBaseUri());

		defaultClient.setRequestInterceptor(builder -> {
			builder.setHeader("X-INSEE-Api-Key-Integration", accessServiceConfig.getKeyIntegration());
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
