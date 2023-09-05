
package org.esupportail.referentiel.sirene.client.form;

import javax.xml.datatype.XMLGregorianCalendar;

public class ParamMASForm {

	protected String codeUOAffectAdresse;

	protected XMLGregorianCalendar dateDebut;

	protected XMLGregorianCalendar dateFin;
	protected String matricule;
	protected int pourcentageAffectation;
	protected String temoinValidite;
	protected String typeAction;
	protected String typeRattachement;

	/**
	 * Obtient la valeur de la propriété codeUOAffectAdresse.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodeUOAffectAdresse() {
		return codeUOAffectAdresse;
	}

	/**
	 * Définit la valeur de la propriété codeUOAffectAdresse.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCodeUOAffectAdresse(String value) {
		this.codeUOAffectAdresse = value;
	}

	/**
	 * Obtient la valeur de la propriété dateDebut.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDateDebut() {
		return dateDebut;
	}

	/**
	 * Définit la valeur de la propriété dateDebut.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateDebut(XMLGregorianCalendar value) {
		this.dateDebut = value;
	}

	/**
	 * Obtient la valeur de la propriété dateFin.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDateFin() {
		return dateFin;
	}

	/**
	 * Définit la valeur de la propriété dateFin.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDateFin(XMLGregorianCalendar value) {
		this.dateFin = value;
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
	 * Obtient la valeur de la propriété pourcentageAffectation.
	 * 
	 */
	public int getPourcentageAffectation() {
		return pourcentageAffectation;
	}

	/**
	 * Définit la valeur de la propriété pourcentageAffectation.
	 * 
	 */
	public void setPourcentageAffectation(int value) {
		this.pourcentageAffectation = value;
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

	/**
	 * Obtient la valeur de la propriété typeAction.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTypeAction() {
		return typeAction;
	}

	/**
	 * Définit la valeur de la propriété typeAction.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTypeAction(String value) {
		this.typeAction = value;
	}

	/**
	 * Obtient la valeur de la propriété typeRattachement.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTypeRattachement() {
		return typeRattachement;
	}

	/**
	 * Définit la valeur de la propriété typeRattachement.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTypeRattachement(String value) {
		this.typeRattachement = value;
	}

}
