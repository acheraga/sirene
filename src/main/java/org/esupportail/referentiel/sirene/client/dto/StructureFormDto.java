package org.esupportail.referentiel.sirene.client.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StructureFormDto {

    
    @Size(max = 20)
    private String libCedex;

    @Size(min = 14, max = 14)
    private String numeroSiret;

    @Size(max = 6)
    private String codeNafN5;

    @NotNull
    @NotEmpty
    @Size(max = 150)
    private String raisonSociale;

    private String activitePrincipale;

    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String telephone;

    @Size(max = 20)
    private String fax;

    @Email
    @Size(max = 50)
    private String mail;

    @Size(max = 200)
    private String siteWeb;

    @NotNull
    private String idEffectif;

    @NotNull
    private int idStatutJuridique;

    private String  libelleStatutJuridique;

    
    @NotNull
    private int idTypeStructure;

    @Size(max = 200)
    private String batimentResidence;

    @NotNull
    @NotEmpty
    @Size(max = 200)
    private String voie;

    @NotNull
    @NotEmpty
    @Size(max = 200)
    private String commune;

    @NotNull
    @Size(max = 10)
    private String codePostal;
    
    @NotNull
    @Size(max = 10)
    private String codeCommune;

    @NotNull
    private int idPays;
    
    @NotNull
    @Size(max = 250)
    private String pays;
    
   	@Size(max = 100)
    private String trancheEffectif;

	public String getLibCedex() {
		return libCedex;
	}

	public void setLibCedex(String libCedex) {
		this.libCedex = libCedex;
	}

	public String getNumeroSiret() {
		return numeroSiret;
	}

	public void setNumeroSiret(String numeroSiret) {
		this.numeroSiret = numeroSiret;
	}

	public String getCodeNafN5() {
		return codeNafN5;
	}

	public void setCodeNafN5(String codeNafN5) {
		this.codeNafN5 = codeNafN5;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getActivitePrincipale() {
		return activitePrincipale;
	}

	public void setActivitePrincipale(String activitePrincipale) {
		this.activitePrincipale = activitePrincipale;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getIdEffectif() {
		return idEffectif;
	}

	public void setIdEffectif(String idEffectif) {
		this.idEffectif = idEffectif;
	}

	public int getIdStatutJuridique() {
		return idStatutJuridique;
	}

	public void setIdStatutJuridique(int idStatutJuridique) {
		this.idStatutJuridique = idStatutJuridique;
	}

	public int getIdTypeStructure() {
		return idTypeStructure;
	}

	public void setIdTypeStructure(int idTypeStructure) {
		this.idTypeStructure = idTypeStructure;
	}

	public String getBatimentResidence() {
		return batimentResidence;
	}

	public void setBatimentResidence(String batimentResidence) {
		this.batimentResidence = batimentResidence;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public int getIdPays() {
		return idPays;
	}

	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public String getTrancheEffectif() {
		return trancheEffectif;
	}

	public void setTrancheEffectif(String trancheEffectif) {
		this.trancheEffectif = trancheEffectif;
	}

	 public String getPays() {
			return pays;
		}

		public void setPays(String pays) {
			this.pays = pays;
		}

		public String getLibelleStatutJuridique() {
			return libelleStatutJuridique;
		}

		public void setLibelleStatutJuridique(String libelleStatutJuridique) {
			this.libelleStatutJuridique = libelleStatutJuridique;
		}
    



}
