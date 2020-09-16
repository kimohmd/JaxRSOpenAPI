package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.istic.taa.jaxrs.domain.Tableau;


public class TableauDAO extends AbstractJpaDao<Long, Tableau>{
	private EntityManager entityManager;
    
    public TableauDAO() {
    	super(Tableau.class);
    }
}