
package org.esupportail.data.sirene.client.form;

import java.io.Serializable;

import javax.xml.datatype.XMLGregorianCalendar;

public class ParamMCBForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2729474804837543683L;
	
	protected String cleCompte;
	protected String codeAgence;
	protected String codeBanque;
	protected XMLGregorianCalendar dateDebBanque;
	protected XMLGregorianCalendar dateFinBanque;
	protected String iban;
	protected String libelleAgence;
	protected String matricule;
	protected String modePaiement;
	protected String numCompte;
	protected String paysBanque;
	protected String swift;
	protected String temoinValidite;

	/**
	 * Obtient la valeur de la propriété cleCompte.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCleCompte() {
		return cleCompte;
	}

	/**
	 * Définit la valeur de la propriété cleCompte.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCleCompte(String value) {
		this.cleCompte = value;
	}

	/**
	 * Obtient la valeur de la propriété codeAgence.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodeAgence() {
		return codeAgence;
	}

	/**
	 * Définit la valeur de la propriété codeAgence.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCodeAgence(String value) {
		this.codeAgence = value;
	}

	/**
	 * Obtient la valeur de la propriété codeBanque.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodeBanque() {
		return codeBanque;
	}

	/**
	 * Définit la valeur de la propriété codeBanque.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCodeBanque(String value) {
		this.codeBanque = value;
	}

	/**
	 * Obtient la valeur de la propriété dateDebBanque.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDateDebBanque() {
		return dateDebBanque;
	}

	/**
	 * Définit la valeur de la propriété dateDebBanque.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateDebBanque(XMLGregorianCalendar value) {
		this.dateDebBanque = value;
	}

	/**
	 * Obtient la valeur de la propriété dateFinBanque.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDateFinBanque() {
		return dateFinBanque;
	}

	/**
	 * Définit la valeur de la propriété dateFinBanque.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateFinBanque(XMLGregorianCalendar value) {
		this.dateFinBanque = value;
	}

	/**
	 * Obtient la valeur de la propriété iban.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIBAN() {
		return iban;
	}

	/**
	 * Définit la valeur de la propriété iban.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setIBAN(String value) {
		this.iban = value;
	}

	/**
	 * Obtient la valeur de la propriété libelleAgence.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLibelleAgence() {
		return libelleAgence;
	}

	/**
	 * Définit la valeur de la propriété libelleAgence.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setLibelleAgence(String value) {
		this.libelleAgence = value;
	}

	/**
	 * Obtient la valeur de la propriété matricule.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Définit la valeur de la propriété matricule.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMatricule(String value) {
		this.matricule = value;
	}

	/**
	 * Obtient la valeur de la propriété modePaiement.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getModePaiement() {
		return modePaiement;
	}

	/**
	 * Définit la valeur de la propriété modePaiement.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setModePaiement(String value) {
		this.modePaiement = value;
	}

	/**
	 * Obtient la valeur de la propriété numCompte.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNumCompte() {
		return numCompte;
	}

	/**
	 * Définit la valeur de la propriété numCompte.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNumCompte(String value) {
		this.numCompte = value;
	}

	/**
	 * Obtient la valeur de la propriété paysBanque.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPaysBanque() {
		return paysBanque;
	}

	/**
	 * Définit la valeur de la propriété paysBanque.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPaysBanque(String value) {
		this.paysBanque = value;
	}

	/**
	 * Obtient la valeur de la propriété swift.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSWIFT() {
		return swift;
	}

	/**
	 * Définit la valeur de la propriété swift.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSWIFT(String value) {
		this.swift = value;
	}

	/**
	 * Obtient la valeur de la propriété temoinValidite.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTemoinValidite() {
		return temoinValidite;
	}

	/**
	 * Définit la valeur de la propriété temoinValidite.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTemoinValidite(String value) {
		this.temoinValidite = value;
	}

}
