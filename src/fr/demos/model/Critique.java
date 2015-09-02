package fr.demos.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Critique")
public class Critique {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCritique;
	@CollectionTable
	@ElementCollection
	private Collection<String> avis;
	@CollectionTable
	@ElementCollection
	private Collection<Integer> note;
	
	
	public Critique() {
		super();
	}
	public Critique(long idCritique, Collection<String> avis,
			Collection<Integer> note) {
		super();
		this.idCritique = idCritique;
		this.avis = avis;
		this.note = note;
	}
	public long getIdCritique() {
		return idCritique;
	}
	public void setIdCritique(long idCritique) {
		this.idCritique = idCritique;
	}
	public Collection<String> getAvis() {
		return avis;
	}
	public void setAvis(Collection<String> avis) {
		this.avis = avis;
	}
	public Collection<Integer> getNote() {
		return note;
	}
	public void setNote(Collection<Integer> note) {
		this.note = note;
	}
	
	
}
