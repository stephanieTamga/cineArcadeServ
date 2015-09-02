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
				// cr�ation d'une variable content la liste des ligne dans le panier
				ArrayList<LignePanier> list = (ArrayList<LignePanier>) this
						.getListelignesPanier();
				// d�claration d'une variable nomm� explicitement qui ontiendra la
				// r�f�rence des produits d�j� dans le panier
				String refDesProduitsDansPanier;
				// boucle for permettant de parcourir la liste des lignes contenues
				// dans le panier
				for (int i = 0; i < list.size(); i++) {
					// instanciation de la variable contenant la r�f�rence de chaque
					// produit dans le panier
					refDesProduitsDansPanier = list.get(i).getProduit()
							.getReferenceProduit();
					// condition v�rifiant que la r�f�rence du produit s�lectionne
					// n'est pas d�j� pr�sente dansle panier
					if (!refDesProduitsDansPanier.equals(refDuProduitSelectionne)) {
						try {
							// r�cup�ration du produit s�lectionn� dans la BDD gr�ce
							// � la r�f�rence pass�e en requ�te
							produit = dao
									.rechercherparReference(refDuProduitSelectionne);
							// association du produit s�lectionn� � une ligne panier
							ligne.setProduit(produit);
							// passage de la quantit� de produit de la ligne � un
							// (1) exemplaire.
							ligne.setQuantite(1);
							// insertion de la ligne conteant le produit s�lectionn�
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
