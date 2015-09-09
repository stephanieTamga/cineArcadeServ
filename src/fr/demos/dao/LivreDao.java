package fr.demos.dao;

import java.util.List;

import fr.demos.model.Livre;
import fr.demos.model.Produit;

public interface LivreDao extends Dao<Livre> {
	List<Livre> rechercheTous() throws Exception;
	Livre rechercherLivreparReference(String refDuProduitSelectionne) throws Exception;

}
