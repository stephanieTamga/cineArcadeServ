package fr.demos.model;


import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dvd")
@DiscriminatorValue("DVD")
public class Dvd extends Produit{
	@CollectionTable
	@ElementCollection
	private Collection<String> langues;
	@CollectionTable
	@ElementCollection
	private Collection<String> acteurs;
	
}
