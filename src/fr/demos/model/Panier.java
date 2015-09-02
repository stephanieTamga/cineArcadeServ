package fr.demos.model;

import java.util.ArrayList;
import java.util.List;

public class Panier {

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

	// permet d'ajouter des lignes contenant des produits dans le panier
	public void ajouterPanier(String refDuProduitSelectionne, 
			Produit produit, int quantite) {
		LignePanier ligne = new LignePanier(quantite, produit);

		// d�claration d'une variable nomm� explicitement qui ontiendra la
		// r�f�rence des produits d�j� dans le panier
		String refDesProduitsDansPanier;
		// boucle for permettant de parcourir la liste des lignes contenues
		// dans le panier
		for (int i = 0; i < listelignePanier.size(); i++) {
			// instanciation de la variable contenant la r�f�rence de chaque
			// produit dans le panier
			refDesProduitsDansPanier = listelignePanier.get(i).getProduit()
					.getReferenceProduit();
			// condition v�rifiant que la r�f�rence du produit s�lectionne
			// n'est pas d�j� pr�sente dansle panier
			if (!refDesProduitsDansPanier.equals(refDuProduitSelectionne)) {
				try {
					// association du produit s�lectionn� � une ligne panier
					ligne.setProduit(produit);
					ligne.setQuantite(quantite);
					// insertion de la ligne conteant le produit s�lectionn�
					// dans la liste des lignes du panier
					listelignePanier.add(ligne);
				} catch (Exception e) {
					e.getCause();
					e.getMessage();
					e.getStackTrace();
				}
			} else {
				listelignePanier.get(i).setQuantite(quantite+listelignePanier.get(i).getQuantite());
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
		return "Panier [idPanier=" + idPanier + ", nbrProduit=" + nbrProduit
				+ ", sommeTotal=" + sommeTotal + ", ListelignesPanier="
				+ listelignePanier + ", client=" + client + ", ifClientAuth="
				+ ifClientAuth + "]";
	}

}
