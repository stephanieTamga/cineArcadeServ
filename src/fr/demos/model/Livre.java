package fr.demos.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="livre")
@DiscriminatorValue("LI")
public class Livre extends Produit {
	@Column(unique = true, nullable=false, length=10)
	private String numeroIsbn;
	@Column(length=20)
	private String genre;
	@Column(length=20)
	private String collection;
	
	
	
	public Livre() {
		super();
	}
	public String getNumeroIsbn() {
		return numeroIsbn;
	}
	public void setNumeroIsbn(String numeroIsbn) {
		this.numeroIsbn = numeroIsbn;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
		
}
