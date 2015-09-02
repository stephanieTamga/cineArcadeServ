package fr.demos.dao;

public interface Dao<T> {
	T rechercheParId(long id);
	void ajout(T t) throws Exception;
	void modification(T t) throws Exception;
	void suppression(long id) throws Exception;
}
