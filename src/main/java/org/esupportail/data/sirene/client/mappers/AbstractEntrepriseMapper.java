package org.esupportail.data.sirene.client.mappers;


import org.esupportail.data.sirene.client.dto.CodeNaf;
import org.esupportail.data.sirene.client.dto.StructureFormDto;
import org.esupportail.data.sirene.client.utils.ChargeurCodeNafJson;
import org.esupportail.data.sirene.client.utils.Pays;
import org.esupportail.data.sirene.client.utils.TrancheEffectif;
import org.esupportail.data.sirene.entreprise.client.model.Adresse;
import org.esupportail.data.sirene.entreprise.client.model.Etablissement;
import org.esupportail.data.sirene.entreprise.client.model.UniteLegaleEtablissement;
import org.slf4j.LoggerFactory;


public abstract class AbstractEntrepriseMapper {

	final private static transient org.slf4j.Logger logger = LoggerFactory.getLogger("AbstractEntrepriseMapper");

	public static StructureFormDto mapper(Etablissement etab) {

		ChargeurCodeNafJson chargeurCodeNafJson = new ChargeurCodeNafJson();

		StructureFormDto dto = new StructureFormDto();

		dto.setNumeroSiret(etab.getSiret());

		UniteLegaleEtablissement unite_legale = etab.getUniteLegale();
		String nom_unite_legale = unite_legale.getNomUniteLegale();
		String raison0 = unite_legale.getDenominationUniteLegale();
		String raison1 = unite_legale.getDenominationUsuelle1UniteLegale();
		String raison2 = unite_legale.getDenominationUsuelle2UniteLegale();
		String raison3 = unite_legale.getDenominationUsuelle3UniteLegale();

		if (nom_unite_legale != null && !nom_unite_legale.isEmpty()) {
			dto.setRaisonSociale(nom_unite_legale);
		} else if (raison0 == null || raison0.isEmpty() || raison0.isBlank()) {
			String r = raison1 != null ? raison1 : raison2 != null ? raison2 : raison3 != null ? raison3 : "NON DEFINI";
			dto.setRaisonSociale(r);
		} else {
			dto.setRaisonSociale(raison0);
		}

		Adresse add = etab.getAdresseEtablissement();

		dto.setCodePostal(add.getCodePostalEtablissement());
		dto.setCodeCommune(add.getCodeCommuneEtablissement());
		dto.setLibCedex(add.getLibelleCedexEtablissement());
		dto.setCommune(add.getLibelleCommuneEtablissement());

		StringBuffer voie = new StringBuffer();

		if (add.getNumeroVoieEtablissement() != null)
			voie.append(add.getNumeroVoieEtablissement()).append(", ");
		if (add.getTypeVoieEtablissement() != null)
			voie.append(add.getTypeVoieEtablissement()).append(" ");
		if (add.getLibelleVoieEtablissement() != null)
			voie.append(add.getLibelleVoieEtablissement());

		dto.setVoie(voie.toString());

		if (add.getCodePaysEtrangerEtablissement() != null) {
			int idPays = Integer.parseInt(add.getCodePaysEtrangerEtablissement());
			dto.setIdPays(idPays);
			Pays pays = new Pays();
			dto.setPays(pays.getPaysMap().get(idPays));

		} else {
			// PaysDTO paysDto = getPaysFromNom("FRANCE");
			dto.setIdPays(82);
			dto.setPays("FRANCE");

		}

		String effectif = unite_legale.getTrancheEffectifsUniteLegale();
		if (effectif != null && !effectif.isBlank() && !effectif.isEmpty()) {
			dto.setTrancheEffectif(TrancheEffectif.getEfftifMap().get(effectif));
			dto.setIdEffectif(effectif);
		}

		try {
			String nature_juridique = unite_legale.getCategorieJuridiqueUniteLegale();
			dto.setIdStatutJuridique(Integer.valueOf(nature_juridique));
		} catch (Exception e) {
			logger.error(" AbstractEntrepriseMapper  siret   : " + dto.getNumeroSiret() + "nature_juridique : "
					+ unite_legale.getCategorieJuridiqueUniteLegale());

		}

		String activitePrincipale = unite_legale.getActivitePrincipaleUniteLegale();

		if (activitePrincipale != null && !activitePrincipale.isEmpty()) {
			// codeNAF_N5
			logger.debug("EntrepriseSireneMapper.mapper()  activitePrincipale :" + activitePrincipale);
			// NafN5DTO activitePrincipaleDto =
			// nomenclatureDomainService.getNafN5FromCode(activitePrincipale);
			dto.setCodeNafN5(activitePrincipale);
			CodeNaf cn = chargeurCodeNafJson.findCodeNafByCode(activitePrincipale);
			if (cn != null) {
				dto.setActivitePrincipale(cn.getIntitulSDeLaNAFRV2VersionFinale());
			}

		}

		return dto;
	}

}
