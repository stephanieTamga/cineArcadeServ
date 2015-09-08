package fr.demos.dao;

import java.util.List;

import fr.demos.model.Produit;

public interface ProduitDao extends Dao<Produit> {
//	Produit rechercherParCritere()throws Exception;
//	Produit RechercherParTitre(String titre) throws Exception;
//	Produit RechercherParAuteur(String auteur) throws Exception;
//	Produit RechercherParEditeur(String editeur) throws Exception;
//	Produit RechercherParnumeroIsbn(long numeroIsbn) throws Exception;
//	Produit RechercherParCollection(String collection) throws Exception;
//	Produit RechercherParGenre(String genre) throws Exception;
//	
<<<<<<< HEAD
	List<Produit> rechercheTous() throws Exception;
//	Produit liste()throws Exception;
=======
	List<Produit> rechercheTous(Produit produit) throws Exception;

>>>>>>> origin/master
	Produit rechercherparReference(String refDuProduitSelectionne) throws Exception;

}
