package fr.demos.model;


import java.util.ArrayList;
import java.util.List;

import fr.demos.dao.ProduitDao;
import fr.demos.model.LignePanier;
import fr.demos.model.Produit;

public class Panier {
	

	private int nbrProduit;
	private double sommeTotal;
	private List<LignePanier> listelignePanier;
	private Client client;
	private boolean ifClientAuth;


	public Panier() {
		super();
	}

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public int getNbrProduit() {
		return nbrProduit;
	}

	public void setNbrProduit(int nbrProduit) {
		this.nbrProduit = nbrProduit;
	}

	public boolean isIfClientAuth() {
		return ifClientAuth;
	}

	public void setIfClientAuth(boolean ifClientAuth) {
		this.ifClientAuth = ifClientAuth;
	}

	public double getSommeTotal() {
		return sommeTotal;
	}

	public void setSommeTotal(double sommeTotal) {
		this.sommeTotal = sommeTotal;
	}
	

	public List<LignePanier> getListelignePanier() {
		return listelignePanier;
	}

	public void setListelignePanier(List<LignePanier> listelignePanier) {
		this.listelignePanier = listelignePanier;
	}
	
	// permet d'ajouter des lignes contenant des produits dans le panier
		public void ajouterPanier(String refDuProduitSelectionne, ProduitDao dao, LignePanier ligne, Produit produit, int quantite) {
			if (this != null) {
				// création d'une variable content la liste des ligne dans le panier
				ArrayList<LignePanier> list = (ArrayList<LignePanier>) this
						.getListelignesPanier();
				// déclaration d'une variable nommé explicitement qui ontiendra la
				// référence des produits déjà dans le panier
				String refDesProduitsDansPanier;
				// boucle for permettant de parcourir la liste des lignes contenues
				// dans le panier
				for (int i = 0; i < list.size(); i++) {
					// instanciation de la variable contenant la référence de chaque
					// produit dans le panier
					refDesProduitsDansPanier = list.get(i).getProduit()
							.getReferenceProduit();
					// condition vérifiant que la référence du produit sélectionne
					// n'est pas déjà présente dansle panier
					if (!refDesProduitsDansPanier.equals(refDuProduitSelectionne)) {
						try {
							// récupération du produit sélectionné dans la BDD grâce
							// à la référence passée en requête
							produit = dao
									.rechercherparReference(refDuProduitSelectionne);
							// association du produit sélectionné à une ligne panier
							ligne.setProduit(produit);
							// passage de la quantité de produit de la ligne à un
							// (1) exemplaire.
							ligne.setQuantite(1);
							// insertion de la ligne conteant le produit sélectionné
							// dans la liste des lignes du panier
							list.add(ligne);
						} catch (Exception e) {
							e.getCause();
							e.getMessage();
							e.getStackTrace();
						}
					} else {
						quantite++;
					}
				}

			}
		}

}
