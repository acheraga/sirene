package org.esupportail.referentiel.sirene.client.dto;

public class CategorieJuridique {

	private String Code;
	private String Libelle;

	
	
	public CategorieJuridique(String code, String libelle) {
		super();
		Code = code;
		Libelle = libelle;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

}
