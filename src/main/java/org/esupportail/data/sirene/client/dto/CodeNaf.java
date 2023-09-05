package org.esupportail.data.sirene.client.dto;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ligne", "Code", 
		"intitulSNAFRV2En65CaractRes",
		"intitulSNAFRV2En40CaractRes",
		"intitulSDeLaNAFRV2VersionFinale" })
@Generated("jsonschema2pojo")
public class CodeNaf {

	@JsonProperty("ligne")
	private Integer ligne;
	@JsonProperty("Code")
	private String code;
	@JsonProperty("intitulSDeLaNAFRV2VersionFinale")
	private String intitulSDeLaNAFRV2VersionFinale;
	@JsonProperty("intitulSNAFRV2En65CaractRes")
	private String intitulSNAFRV2En65CaractRes;
	@JsonProperty("intitulSNAFRV2En40CaractRes")
	private String intitulSNAFRV2En40CaractRes;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("ligne")
	public Integer getLigne() {
		return ligne;
	}

	@JsonProperty("ligne")
	public void setLigne(Integer ligne) {
		this.ligne = ligne;
	}

	@JsonProperty("Code")
	public String getCode() {
		return code;
	}

	@JsonProperty("Code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("Intitul\u00e9s de la NAF r\u00e9v. 2, version finale")
	public String getIntitulSDeLaNAFRV2VersionFinale() {
		return intitulSDeLaNAFRV2VersionFinale;
	}

	@JsonProperty("intitulSDeLaNAFRV2VersionFinale")
	public void setIntitulSDeLaNAFRV2VersionFinale(String intitulSDeLaNAFRV2VersionFinale) {
		this.intitulSDeLaNAFRV2VersionFinale = intitulSDeLaNAFRV2VersionFinale;
	}

	@JsonProperty("intitulSNAFRV2En65CaractRes")
	public String getIntitulSNAFRV2En65CaractRes() {
		return intitulSNAFRV2En65CaractRes;
	}

	@JsonProperty("intitulSNAFRV2En65CaractRes")
	public void setIntitulSNAFRV2En65CaractRes(String intitulSNAFRV2En65CaractRes) {
		this.intitulSNAFRV2En65CaractRes = intitulSNAFRV2En65CaractRes;
	}

	@JsonProperty("intitulSNAFRV2En40CaractRes")
	public String getIntitulSNAFRV2En40CaractRes() {
		return intitulSNAFRV2En40CaractRes;
	}

	@JsonProperty("intitulSNAFRV2En40CaractRes")
	public void setIntitulSNAFRV2En40CaractRes(String intitulSNAFRV2En40CaractRes) {
		this.intitulSNAFRV2En40CaractRes = intitulSNAFRV2En40CaractRes;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "CodeNaf [ligne=" + ligne + ", code=" + code + ", intitulSDeLaNAFRV2VersionFinale="
				+ intitulSDeLaNAFRV2VersionFinale + ", intitulSNAFRV2En65CaractRes=" + intitulSNAFRV2En65CaractRes
				+ ", intitulSNAFRV2En40CaractRes=" + intitulSNAFRV2En40CaractRes + "]";
	}
	
	

}
