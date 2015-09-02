package fr.demos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table
public class PrixProduit {

	private String prixHT;
	private String tauxTaxeProduit;
	private String devise;
	
	
	public String getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(String prixHT) {
		this.prixHT = prixHT;
	}

	public String getTauxTaxeProduit() {
		return tauxTaxeProduit;
	}

	public void setTauxTaxeProduit(String tauxTaxeProduit) {
		this.tauxTaxeProduit = tauxTaxeProduit;
	}

	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	
}
