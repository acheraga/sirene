package org.esupportail.referentiel.sirene.client.service;

import java.util.ArrayList;
import java.util.List;

import org.esupportail.data.sirene.entreprise.client.api.EtablissementApi;
import org.esupportail.data.sirene.entreprise.client.invoker.ApiException;
import org.esupportail.data.sirene.entreprise.client.model.Etablissement;
import org.esupportail.data.sirene.entreprise.client.model.ReponseEtablissement;
import org.esupportail.data.sirene.entreprise.client.model.ReponseEtablissements;
import org.esupportail.referentiel.sirene.client.dto.StructureFormDto;
import org.esupportail.referentiel.sirene.client.mappers.AbstractEntrepriseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SireneService implements SireneServiceI {

	final private transient Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccessService accessService;

	@Override
	public StructureFormDto findBySiret(String siret) {
		// TODO Auto-generated method stub
		String date = null;
		String champs = null;
		Boolean masquerValeursNulles = null;

		EtablissementApi api = accessService.getEtablissementApi();

		try {
			ReponseEtablissement response = api.findBySiret(siret, date, champs, masquerValeursNulles);
			return AbstractEntrepriseMapper.mapper(response.getEtablissement());

		} catch (ApiException e) {
			logger.error(e.getMessage() + ": " + e.getCode());
			return null;
		}

	}

	@Override
	public List<StructureFormDto> findByMotcleCp(String cp, String motcle) {
		
		EtablissementApi api = accessService.getEtablissementApi();
		String q = "denominationUniteLegale:\"%s\"* AND ( codeCommuneEtablissement:%s OR codePostalEtablissement:%s )";

		String query = String.format(q, motcle, cp, cp);
		logger.info("findEtablissementDataGouvByRaiosnEtCP query : " + query);
		String date = null;
		String champs = null;
		Boolean masquerValeursNulles = null;
		String facetteChamp = null;
		String tri = null;
		Integer nombre = 20;
		Integer debut = null;
		String curseur = null;

		List<StructureFormDto> etabs = new ArrayList<>();
		try {
			ReponseEtablissements response = api.findSiretByQ(query, date, champs, masquerValeursNulles, facetteChamp,
					tri, nombre, debut, curseur);
			List<Etablissement> etablissements = response.getEtablissements();
			
			for (Etablissement etab : etablissements) {

				StructureFormDto etabEnBase = AbstractEntrepriseMapper.mapper(etab);

				etabs.add(etabEnBase);
			}

		} catch (ApiException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

		// TODO Auto-generated method stub
		return etabs;

	}

	public AccessService getAccessService() {
		return accessService;
	}

	public void setAccessService(AccessService accessService) {
		this.accessService = accessService;
	}

}
