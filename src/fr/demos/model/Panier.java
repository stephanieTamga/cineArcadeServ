package fr.demos.model;


import java.util.List;

public class Panier {
	

	private int nbrProduit;
	private double sommeTotal;
	private List<LignePanier> listelignePaniers;
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
	

	public List<LignePanier> getListelignePaniers() {
		return listelignePaniers;
	}

	public void setListelignePaniers(List<LignePanier> listelignePaniers) {
		this.listelignePaniers = listelignePaniers;
	}

}
