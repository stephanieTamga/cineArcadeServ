package fr.demos.dao;

import java.util.List;

import fr.demos.model.Client;

public interface ClientDao extends Dao<Client> {
	
	List<Client> rechercheParNom(String nom) throws Exception;
}
