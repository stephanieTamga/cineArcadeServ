package fr.demos.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.dao.ProduitDao;
import fr.demos.model.Livre;
import fr.demos.model.Produit;

public class ProduitDaoJpa implements ProduitDao{

	@Override
	public Produit rechercheParId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajout(Produit t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modification(Produit t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppression(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@PersistenceContext
	private EntityManager em;
////	@Resource
////	private UserTransaction ut;
//	@Override
//	public Livre rechercheParId(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void suppression(long id) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Livre rechercherParCritere() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Livre RechercherParTitre(String titre) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Livre RechercherParAuteur(String auteur) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Livre RechercherParEditeur(String editeur) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Livre RechercherParnumeroIsbn(long numeroIsbn) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Livre RechercherParCollection(String collection) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Livre RechercherParGenre(String genre) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Livre liste() throws Exception {
//		return null;
//	}

	@Override
	public List<Produit> rechercheTous() throws Exception {
		TypedQuery<Produit> query = em.createQuery("from Produit p ",
				Produit.class);

		List<Produit> listeProduit = query.getResultList();

		for (Produit pr : listeProduit) {

			System.out.println("dao:" + pr.getConcepteur());
		}
		return listeProduit;
	}
//
//	@Override
//	public void ajout(Produit t) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void modification(Produit t) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

@Override
public Produit rechercherparReference(String refDuProduitSelectionne)
		throws Exception {
	// TODO Auto-generated method stub
	return null;
}


}
