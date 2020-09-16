package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.istic.taa.jaxrs.domain.Utilisateur;





public class UtilisateurDAO extends AbstractJpaDao<Long, Utilisateur>{
	private EntityManager entityManager;
    
    public UtilisateurDAO() {
    	super(Utilisateur.class);

}

}