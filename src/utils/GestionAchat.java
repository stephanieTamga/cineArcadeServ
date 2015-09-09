package utils;

import fr.demos.model.Produit;

public class GestionAchat {
	Produit produit;
	private int stock;
	
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	synchronized void ajouterStock(int nombre){
		this.produit.getStockActuel();
	}
	public void  retirerStock(int nombre) throws ExceptionStock{
		if(nombre<0){
			throw new ExceptionNegativeValue(nombre);
		}
	if(nombre<=this.stock){
		this.stock -=nombre;
	}
	else{
		throw new ExceptionStock(nombre, nombre, produit);
	}
	this.stock=nombre;
	}

}
