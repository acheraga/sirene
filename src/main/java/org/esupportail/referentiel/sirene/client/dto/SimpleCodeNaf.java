package org.esupportail.referentiel.sirene.client.dto;

public class SimpleCodeNaf {

	private int id;

	private String Code;

	private String intitule;

	private String intituleCourt;

	private String intituleCourtC;

	public SimpleCodeNaf(int id, String code, String intitule, String intituleCourt, String intituleCourtC) {
		super();
		this.id = id;
		Code = code;
		this.intitule = intitule;
		this.intituleCourt = intituleCourt;
		this.intituleCourtC = intituleCourtC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getIntituleCourt() {
		return intituleCourt;
	}

	public void setIntituleCourt(String intituleCourt) {
		this.intituleCourt = intituleCourt;
	}

	public String getIntituleCourtC() {
		return intituleCourtC;
	}

	public void setIntituleCourtC(String intituleCourtC) {
		this.intituleCourtC = intituleCourtC;
	}

}
