package fr.demos.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import fr.demos.dao.ClientDao;
import fr.demos.model.Client;

public class ClientDaoJpa implements ClientDao  {
	@PersistenceContext
	private EntityManager em;
	//@Resource
	//private UserTransaction ut;

	@Override
	public Client rechercheParId(long id) {
		// TODO Auto-generated method stub
		return em.find(Client.class, id);
	}



	@Override
	@Transactional
	public void ajout(Client t) throws Exception {
		// TODO Auto-generated method stub
		//ut.begin();
		em.persist(t);
		//ut.commit();
	}



	@Override
	public void modification(Client t) throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
	}



	@Override
	public void suppression(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> rechercheParNom(String nom) throws Exception {
//		ut.begin();
//		String requete = "select d from Dvd d where d.titre like ?1 and d.proprietaire.pseudo = ?2";
//		TypedQuery<Dvd> query = em.createQuery(requete,Dvd.class);
//		query.setParameter(1,"%"+critere+"%");
//		query.setParameter(2,p.getPseudo());
//		List <Dvd> listeDvd =query.getResultList();	
//		for (Dvd d:listeDvd){
//			System.out.println(d.getProprietaire().getPseudo());
//		}
//		ut.commit();
//		return listeDvd;
		return null;
	}



}
