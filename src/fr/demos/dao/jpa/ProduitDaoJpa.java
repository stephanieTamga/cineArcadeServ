package fr.demos.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.dao.ProduitDao;

import fr.demos.model.Livre;
import fr.demos.model.Produit;

public class ProduitDaoJpa implements ProduitDao {

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

//
//	@Override
//	public List<Produit> rechercheTous(Produit produit) throws Exception {
//		TypedQuery<Produit> query = em.createQuery("from Produit p ",
//				Produit.class);
//
//		List<Produit> listeProduit = query.getResultList();
//
//		for (Produit pr : listeProduit) {
//
//			System.out.println("dao:" + pr.getConcepteur());
//		}
//		return listeProduit;
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

	@Override
	public Produit rechercherparReference(String referenceProduit, Produit p)
			throws Exception {
	//	String requete = "select p.concepteur from Produit p where p.referenceProduit = ?1";
//		TypedQuery<String[]> query = em.createQuery(requete,String[].class);
		
		
		TypedQuery<Produit> query = em.createQuery(
			"from Produit p  where p.referenceProduit= ?1",
			Produit.class);
		query.setParameter(1, p.getReferenceProduit());
		
		
		System.out.println("DAO :" + referenceProduit);
		return p;
	
	
	

	
	// Produit produitSelectionne = em.find(Produit.class,(String)
	// referenceProduit);

}
}
