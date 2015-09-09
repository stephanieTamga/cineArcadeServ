package fr.demos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utils.ExceptionNegativeValue;
import utils.ExceptionStock;

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
		LignePanier ligne;

		// d�claration d'une variable nomm� explicitement qui ontiendra la
		// r�f�rence des produits d�j� dans le panier
		String refDuProduit;

		// boucle for permettant de parcourir la liste des lignes existantes
		// dans le panier
		boolean refTrouve = false;
		for (int i = 0; i < listelignePanier.size(); i++) {
			// instanciation de la variable contenant la r�f�rence de chaque
			// produit dans le panier
			refDuProduit = listelignePanier.get(i).getProduit()
					.getReferenceProduit();

			if (refDuProduit.equals(refDuProduitSelestionne)) {
				refTrouve = true;
				System.out.println("la refernce du produit  2est: "
						+ refDuProduit);
				System.out
						.println("modif de la quantit� d'une ligne dans le panier "
								+ refDuProduitSelestionne);
				listelignePanier.get(i).setQuantite(
						quantite + listelignePanier.get(i).getQuantite());
				sommeTotal += ((produit.getPrixProduit().getPrixHT()) * quantite);
				System.out
						.println("la somme totale si ref=refRecherchee trouvee: "
								+ sommeTotal);
				nbrProduit += quantite;
				System.out.println("le nombre de produit:" + nbrProduit);
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
				sommeTotal += ((produit.getPrixProduit().getPrixHT()) * quantite);
				System.out.println("la somme totale si refRech non trouv�: "
						+ sommeTotal);
				nbrProduit += ligne.getQuantite();
				System.out.println("le nombre de produit:" + nbrProduit);
			} catch (Exception e) {
				// mauvaise gestion, valable pour le debugging
				e.printStackTrace();

			}

		}

	}

	public void supprimerPanier(String refDuProduitSelestionne,
			Produit produit, int quantite) throws ExceptionNegativeValue {
		System.out.println("appel suprimer");
		LignePanier ligne;

		// d�claration d'une variable nomm� explicitement qui ontiendra la
		// r�f�rence des produits d�j� dans le panier
		String refDuProduit;

		// boucle for permettant de parcourir la liste des lignes existantes
		// dans le panier
		boolean refTrouve = false;
		
		for (int i = 0; i < listelignePanier.size(); i++) {
			// instanciation de la variable contenant la r�f�rence de chaque
			// produit dans le panier
			ligne=listelignePanier.get(i);
			refDuProduit = ligne.getProduit()
					.getReferenceProduit();

			if (refDuProduit.equals(refDuProduitSelestionne)) {
				refTrouve = true;
				System.out.println("la reference du produit  2 est: "
						+ refDuProduit);
				System.out
						.println("modif de la quantit� d'une ligne dans le panier "
								+ refDuProduitSelestionne);
				listelignePanier.get(i).setQuantite(
						quantite + ligne.getQuantite());

				// reduction de la somme
				if (sommeTotal < 0) {
					throw new ExceptionNegativeValue(quantite);

				} else {
					// soustraction effectue depuis les ligne
					sommeTotal -= ((produit.getPrixProduit().getPrixHT()) * quantite);
					System.out
							.println("la somme totale si ref=refRecherchee trouvee apres soustraction : "
									+ sommeTotal);

				}

				// reduction de la quantit�
				if (nbrProduit < 1) {
					throw new ExceptionNegativeValue(quantite);

				} else {
					// soustraction effectue depuis les ligne

					nbrProduit -= quantite;
					System.out
							.println("le nombre de produit apres soustraction:"
									+ nbrProduit);
				}

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
				listelignePanier.remove(ligne);

				if (nbrProduit < 1 || sommeTotal < 0) {
					throw new ExceptionNegativeValue(quantite);
				} else {
					sommeTotal -= ((produit.getPrixProduit().getPrixHT()) * quantite);
					System.out
							.println("la somme totale si refRech non trouv�: "
									+ sommeTotal);
					nbrProduit -= ligne.getQuantite();
					System.out
							.println("le nombre de produit apres soustraction:"
									+ nbrProduit);
				}

			} catch (Exception e) {
				// mauvaise gestion, valable pour le debugging
				e.printStackTrace();

			}

		}

	}

	public void clearPanier() {
		System.out.println("appel Clean Panier");

		// d�claration d'une variable nomm� explicitement qui ontiendra la
		// r�f�rence des produits d�j� dans le panier

		// Creation d'une nouvelle liste: le panier est vid�
		//this.listelignePanier = new ArrayList<LignePanier>();
		
		for (int i = 0; i < listelignePanier.size(); i++) {
			listelignePanier.clear();
		}
		System.out.println("Le panier est vid�");

	}

}
