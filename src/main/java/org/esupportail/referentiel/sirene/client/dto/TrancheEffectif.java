package org.esupportail.referentiel.sirene.client.dto;

import java.util.Objects;

public class TrancheEffectif {

	private String Code;
	private String Libelle;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(Code, Libelle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrancheEffectif other = (TrancheEffectif) obj;
		return Objects.equals(Code, other.Code) && Objects.equals(Libelle, other.Libelle);
	}

	public TrancheEffectif(String code, String libelle) {
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
