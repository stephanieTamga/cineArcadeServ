package fr.demos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Lignecommande")
public class LigneCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLigneCommande;
	@Column(length=200)
	private String referenceProduit;
	// ajouter ligne produit
	@Column(length = 200)
	private String designation;
	
	// ajout ref
	private int quantite;
	private double prixHT;
	
	public long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}
	

	public String getReferenceProduit() {
		return referenceProduit;
	}

	public void setReferenceProduit(String referenceProduit) {
		this.referenceProduit = referenceProduit;
	}

	@Override
	public String toString() {
		return "LigneCommande [designation=" + designation + ", quantite="
				+ quantite + ", prixHT=" + prixHT + "]";
	}

	
}
