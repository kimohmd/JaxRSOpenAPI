package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.istic.taa.jaxrs.domain.Fiche;



public class FicheDAO extends AbstractJpaDao<Long, Fiche>{
	private EntityManager entityManager;
    
    public FicheDAO() {
    	super(Fiche.class);
    }
}