package fr.demos.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.dao.LivreDao;
import fr.demos.model.Livre;
import fr.demos.model.Livre;

public class LivreDaoJpa implements LivreDao {

	@Override
	public Livre rechercheParId(long id) {
		String requete = "select p from Livre p where p.idLivre = ?1";
		TypedQuery<Livre> query = em.createQuery(requete, Livre.class);
		query.setParameter(1, id);
		return query.getSingleResult();
		// return em.find(Livre.class, id);
	}

	@Override
	public void ajout(Livre t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modification(Livre t) throws Exception {
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
	// public List<Livre> rechercheTous(Livre produit) throws Exception {
	// TypedQuery<Livre> query = em.createQuery("from Livre p ",
	// Livre.class);
	//
	// List<Livre> listeLivre = query.getResultList();
	//
	// for (Livre pr : listeLivre) {
	//
	// System.out.println("dao:" + pr.getConcepteur());
	// }
	// return listeLivre;
	// }

	
	
	@Override
	public Livre rechercherLivreparReference(String refDuLivreSelectionne)
			throws Exception {
		String requete = "select l from Livre l where l.referenceProduit = ?1";
		TypedQuery<Livre> query = em.createQuery(requete, Livre.class);
		query.setParameter(1, refDuLivreSelectionne);
		return query.getSingleResult();

		// Livre produitSelectionne = em.find(Livre.class,(String)
		// referenceLivre);

	}

	@Override
	public List<Livre> rechercheTous() throws Exception {
		TypedQuery<Livre> query = em.createQuery("from Livre p ",
				Livre.class);

		List<Livre> listeLivre = query.getResultList();

		for (Livre pr : listeLivre) {

			System.out.println("dao:" + pr.getConcepteur());
		}
		return listeLivre;
	}

}
