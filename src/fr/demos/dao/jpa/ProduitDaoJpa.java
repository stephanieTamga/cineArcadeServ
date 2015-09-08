package fr.demos.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.dao.ProduitDao;
import fr.demos.model.Produit;

public class ProduitDaoJpa implements ProduitDao {

	@Override
	public Produit rechercheParId(long id) {
		String requete = "select p from Produit p where p.idProduit = ?1";
		TypedQuery<Produit> query = em.createQuery(requete, Produit.class);
		query.setParameter(1, id);
		return query.getSingleResult();
		// return em.find(Produit.class, id);
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
	// @Override
	// public List<Produit> rechercheTous(Produit produit) throws Exception {
	// TypedQuery<Produit> query = em.createQuery("from Produit p ",
	// Produit.class);
	//
	// List<Produit> listeProduit = query.getResultList();
	//
	// for (Produit pr : listeProduit) {
	//
	// System.out.println("dao:" + pr.getConcepteur());
	// }
	// return listeProduit;
	// }

	@Override
	public Produit rechercherparReference(String refDuProduitSelectionne)
			throws Exception {
		String requete = "select p from Produit p where p.referenceProduit = ?1";
		TypedQuery<Produit> query = em.createQuery(requete, Produit.class);
		query.setParameter(1, refDuProduitSelectionne);
		return query.getSingleResult();

		// Produit produitSelectionne = em.find(Produit.class,(String)
		// referenceProduit);

	}

	@Override
	public List<Produit> rechercheTous(Produit produit) throws Exception {
		TypedQuery<Produit> query = em.createQuery("from Produit p ",
				Produit.class);

		List<Produit> listeProduit = query.getResultList();

		for (Produit pr : listeProduit) {

			System.out.println("dao:" + pr.getConcepteur());
		}
		return listeProduit;
	}

}
