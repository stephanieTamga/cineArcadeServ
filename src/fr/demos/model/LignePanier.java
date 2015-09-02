package fr.demos.model;

public class LignePanier {
	private int quantite;
	private Produit produit;
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
		
}
