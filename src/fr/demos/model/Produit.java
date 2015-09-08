package fr.demos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProduit;
	@Column(unique=true, nullable=false)
	private String referenceProduit;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(length = 30)
	private String designation;
	@Column(length = 30)
	private String categorie;
	@Column(length = 30)
	private String fabriquant;
	@Column(nullable = false, length = 30)
	private String concepteur;
	@Column(length = 200)
	private String description;
	@Column(length = 200)
	private String Caracteristiques;
	@Column(length = 30)
	private boolean virtuel;
	@Column(length = 30)
	private int stockActuel;
	@Embedded
	private PrixProduit prixProduit;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Critique> critique;
	@ManyToOne
	@JoinTable(name="idPartenaire")
	private PartenaireCommercial partenaire;
	private String image;

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFabriquant() {
		return fabriquant;
	}

	public void setFabriquant(String fabriquant) {
		this.fabriquant = fabriquant;
	}

	public String getConcepteur() {
		return concepteur;
	}

	public String setConcepteur(String concepteur) {
		return this.concepteur = concepteur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCaracteristiques() {
		return Caracteristiques;
	}

	public void setCaracteristiques(String caracteristiques) {
		Caracteristiques = caracteristiques;
	}

	public boolean isVirtuel() {
		return virtuel;
	}

	public void setVirtuel(boolean virtuel) {
		this.virtuel = virtuel;
	}

	public int getStockActuel() {
		return stockActuel;
	}

	public void setStockActuel(int stockActuel) {
		this.stockActuel = stockActuel;
	}

	public PrixProduit getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(PrixProduit prixProduit) {
		this.prixProduit = prixProduit;
	}

	public List<Critique> getCritique() {
		return critique;
	}

	public void setCritique(List<Critique> critique) {
		this.critique = critique;
	}

	public String getReferenceProduit() {
		return referenceProduit;
	}

	public String setReferenceProduit(String referenceProduit) {
		return this.referenceProduit = referenceProduit;
	}

	public PartenaireCommercial getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(PartenaireCommercial partenaire) {
		this.partenaire = partenaire;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Produit() {
		super();
	}

	
	
}
