package fr.demos.model;

public class LignePanier {
	private int quantite;
	private Produit produit;
	private double prixttcLigne;
	
	public double getPrixttcLigne() {
		double prixHt= produit.getPrixProduit().getPrixHT();
		double tva = produit.getPrixProduit().getTauxTaxeProduit();
		double prixttcLigne = prixHt*tva*quantite;
		return prixttcLigne;
	}
	public void setPrixttcLigne(double prixttcLigne) {
		this.prixttcLigne = prixttcLigne;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public LignePanier(int quantite, Produit produit) {
		super();
		this.quantite = quantite;
		this.produit = produit;
	}
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public LignePanier() {
		super();
	}
	
	
//	public double getPrixttcLigne(){
//		double prixHt= produit.getPrixProduit().getPrixHT();
//		double tva = produit.getPrixProduit().getTauxTaxeProduit();
//		double som = prixHt*tva*quantite;
//		return som;
//		
//	}
		
}
