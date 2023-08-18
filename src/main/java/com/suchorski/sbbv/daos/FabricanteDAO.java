package com.suchorski.sbbv.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.suchorski.sbbv.generics.GenericDAO;
import com.suchorski.sbbv.models.Fabricante;
import com.suchorski.sbbv.models.Fabricante_;

public class FabricanteDAO extends GenericDAO<Fabricante, Long> {
	
	public FabricanteDAO() {
		super(Fabricante.class);
	}
	
	@Override
	public List<Fabricante> list() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Fabricante> criteriaQuery = criteriaBuilder.createQuery(Fabricante.class);
		Root<Fabricante> root = criteriaQuery.from(Fabricante.class);
		criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get(Fabricante_.fabricante)));
		TypedQuery<Fabricante> typedQuery = getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
