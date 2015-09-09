package utils;

import fr.demos.model.Produit;

public class ExceptionStock  extends Exception{
	private int stock;
	private Number nombre;
	private Produit produit;
	
	public ExceptionStock(int stock, Number nombre, Produit produit){
		super();
		this.stock= stock;
		this.nombre=nombre;
		this.produit= produit;
	}
	

}
