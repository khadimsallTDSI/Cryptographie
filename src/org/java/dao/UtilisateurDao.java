package org.java.dao;

	import java.util.List;

	import nom.Utilisateur;

	public interface UtilisateurDao {
	    void ajouter( Utilisateur utilisateur ) throws DaoException;
	    List<Utilisateur> lister() throws DaoException;
	}
	
	

