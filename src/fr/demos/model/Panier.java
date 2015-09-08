package fr.demos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Panier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idPanier;

	private int nbrProduit;

	private double sommeTotal;

	private List<LignePanier> listelignePanier;

	private Client client;

	private boolean ifClientAuth;

	public Panier() {
		super();
		this.listelignePanier = new ArrayList<LignePanier>();
		this.ifClientAuth = false;
	}

	public Panier(Client client, boolean ifClientAuth) {
		// rappelle le constructeur sans param�tres (liste reconstruite)
		this();

		this.ifClientAuth = true;
		this.client = client;
	}
	/*
	 * 
	 */
	
	// permet d'ajouter des lignes contenant des produits dans le panier
	public void ajouterPanier(String refDuProduitSelestionne, Produit produit, int quantite) {
		System.out.println("appel ajout");
		LignePanier ligne;
		double prixHt= produit.getPrixProduit().getPrixHT();
		double tva = produit.getPrixProduit().getTauxTaxeProduit();
		double prixttcLigne = prixHt*tva*quantite;

		// d�claration d'une variable nomm� explicitement qui ontiendra la
		// r�f�rence des produits d�j� dans le panier
		String refDuProduit;

		// boucle for permettant de parcourir la liste des lignes existantes
		// dans le panier
		boolean refTrouve = false;
		for (int i = 0; i < listelignePanier.size(); i++) {
			// instanciation de la variable contenant la r�f�rence de chaque
			// produit dans le panier
			refDuProduit = listelignePanier.get(i).getProduit().getReferenceProduit();
			// condition v�rifiant que la r�f�rence du produit s�lectionne
			// n'est pas d�j� pr�sente dansle panier
			if (refDuProduit.equals(refDuProduitSelestionne)) {
				refTrouve = true;
				System.out.println("modif de la quantit� d'une ligne dans le panier " + refDuProduitSelestionne);
				listelignePanier.get(i).setQuantite(
						quantite + listelignePanier.get(i).getQuantite());
				break;
			}
		}
		if (!refTrouve) {
			try {
				// association du produit s�lectionn� � une ligne panier
				ligne = new LignePanier(quantite, produit);
				ligne.setProduit(produit);
				ligne.setQuantite(quantite);
				// insertion de la ligne conteant le produit s�lectionn�
				// dans la liste des lignes du panier

				System.out.println("ajout d'une ligne dans le panier" + ligne);
				listelignePanier.add(ligne);
			} catch (Exception e) {
				// mauvaise gestion, valable pour le debugging
				e.printStackTrace();
			}

		}

	}
	

	/*
	 * public int getNombreProduits() {
	 * 
	 * }
	 */
	

	public long getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(long idPanier) {
		this.idPanier = idPanier;
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

	@Override
	public String toString() {
		return ":" + listelignePanier;
	}

}
