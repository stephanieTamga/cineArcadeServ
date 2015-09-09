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
		// rappelle le constructeur sans paramètres (liste reconstruite)
		this();

		this.ifClientAuth = true;
		this.client = client;
	}

	public long getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(long idPanier) {
		this.idPanier = idPanier;
	}

	public int getNbrProduit() {
		return nbrProduit;
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

	

	public List<LignePanier> getListelignePanier() {
		return listelignePanier;
	}

	

	@Override
	public String toString() {
		return ":" + listelignePanier;
	}

	// permet d'ajouter des lignes contenant des produits dans le panier
	// <<<<<<< HEAD
	// public void ajouterPanier(String refDuProduitSelectionne, Produit
	// produit,
	// int quantite) {
	// LignePanier ligne = new LignePanier(quantite, produit);
	//
	// =======
	public void ajouterPanier(String refDuProduitSelestionne, Produit produit,
			int quantite) {
		System.out.println("appel ajout");
		LignePanier ligne=null;
		

		// déclaration d'une variable nommé explicitement qui ontiendra la
		// référence des produits déjà dans le panier
		String refDuProduit;

		// boucle for permettant de parcourir la liste des lignes existantes
		// dans le panier
		boolean refTrouve = false;
		for (int i = 0; i < listelignePanier.size(); i++) {
			// instanciation de la variable contenant la référence de chaque
			// produit dans le panier
			ligne=listelignePanier.get(i);
			refDuProduit = ligne.getProduit()
					.getReferenceProduit();

			if (refDuProduit.equals(refDuProduitSelestionne)) {
				refTrouve = true;
				System.out.println("la refernce du produit  2est: "
						+ refDuProduit);
				System.out
						.println("modif de la quantité d'une ligne dans le panier "
								+ refDuProduitSelestionne);
				ligne.setQuantite(
						quantite + ligne.getQuantite());
				
				break;
			}
		}
		if (!refTrouve) {
			try {
				// association du produit sélectionné à une ligne panier
				ligne = new LignePanier(quantite, produit);
				ligne.setProduit(produit);
				ligne.setQuantite(quantite);
				// insertion de la ligne conteant le produit sélectionné
				// dans la liste des lignes du panier

				System.out.println("ajout d'une ligne dans le panier" + ligne);
				listelignePanier.add(ligne);
				
				
			} catch (Exception e) {
				// mauvaise gestion, valable pour le debugging
				e.printStackTrace();

			}

		}
		// calcul prix total et nb produit
		
		sommeTotal+=ligne.getPrixttcLigne();
		System.out
				.println("la somme totale si ref=refRecherchee trouvee: "
						+ sommeTotal);
		nbrProduit += quantite;
		
		System.out.println("le nombre de produit:" + nbrProduit);

	}
	

	/*
	 * public int getNombreProduits() {
	 * 
	 * }
	 */

	public void supprimerPanier(String refDuProduitSelestionne, Produit produit,
			int quantite) {
		System.out.println("appel suprimer");
		LignePanier ligne;

		// déclaration d'une variable nommé explicitement qui ontiendra la
		// référence des produits déjà dans le panier
		String refDuProduit;


		// boucle for permettant de parcourir la liste des lignes existantes
		// dans le panier
		boolean refTrouve = false;
		for (int i = 0; i < listelignePanier.size(); i++) {
			// instanciation de la variable contenant la référence de chaque
			// produit dans le panier
			refDuProduit = listelignePanier.get(i).getProduit()
					.getReferenceProduit();

			if (refDuProduit.equals(refDuProduitSelestionne)) {
				refTrouve = true;
				System.out.println("la reference du produit  2 est: "
						+ refDuProduit);
				System.out
						.println("modif de la quantité d'une ligne dans le panier "
								+ refDuProduitSelestionne);
				listelignePanier.get(i).setQuantite(
						quantite + listelignePanier.get(i).getQuantite());
				
				// soustraction effectue depuis les ligne
				sommeTotal -= ((produit.getPrixProduit().getPrixHT()) * quantite);
				System.out
						.println("la somme totale si ref=refRecherchee trouvee après soustraction : "
								+ sommeTotal);
				// reduction de la quantité
				nbrProduit -= quantite;
				System.out.println("le nombre de produit après soustraction:" + nbrProduit);
				break;
			}
		}
		if (!refTrouve) {
			try {
				// association du produit sélectionné à une ligne panier
				ligne = new LignePanier(quantite, produit);
				ligne.setProduit(produit);
				ligne.setQuantite(quantite);
				// insertion de la ligne conteant le produit sélectionné
				// dans la liste des lignes du panier

				System.out.println("ajout d'une ligne dans le panier" + ligne);
				listelignePanier.remove(ligne);
				sommeTotal -= ((produit.getPrixProduit().getPrixHT()) * quantite);
				System.out.println("la somme totale si refRech non trouvé: "
						+ sommeTotal);
				nbrProduit -= ligne.getQuantite();
				System.out.println("le nombre de produit:" + nbrProduit);
			} catch (Exception e) {
				// mauvaise gestion, valable pour le debugging
				e.printStackTrace();

			}

		}

	}

}
