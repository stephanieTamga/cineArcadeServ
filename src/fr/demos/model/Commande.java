package fr.demos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCommande;
	@Temporal(TemporalType.DATE)
	private Date date_commande;
	@Temporal(TemporalType.DATE)
	private Date date_livraison;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "commande_ligneCommande", joinColumns = @JoinColumn(name = "idCommande"), inverseJoinColumns = @JoinColumn(name = "idLigneCommande"))
	private List<LigneCommande> listeligneCommandes;

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public Date getDate_livraison() {
		return date_livraison;
	}

	public void setDate_livraison(Date date_livraison) {
		this.date_livraison = date_livraison;
	}

	

	public List<LigneCommande> getListeligneCommandes() {
		return listeligneCommandes;
	}

	public void setListeligneCommandes(List<LigneCommande> listeligneCommandes) {
		this.listeligneCommandes = listeligneCommandes;
	}

	@Override
	public String toString() {
		return "Commande [date_commande=" + date_commande + ", date_livraison="
				+ date_livraison + "]";
	}

}
