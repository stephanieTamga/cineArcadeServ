package fr.demos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table
public class PrixProduit {

	private double prixHT;
	private double  tauxTaxeProduit;
	private String devise;
	
	


	public double getPrixHT() {
		return prixHT;
	}
	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}
	public double getTauxTaxeProduit() {
		return tauxTaxeProduit;
	}
	public void setTauxTaxeProduit(double tauxTaxeProduit) {
		this.tauxTaxeProduit = tauxTaxeProduit;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	
}
