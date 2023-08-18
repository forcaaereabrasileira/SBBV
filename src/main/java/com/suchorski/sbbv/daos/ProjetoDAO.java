package com.suchorski.sbbv.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.suchorski.sbbv.generics.GenericDAO;
import com.suchorski.sbbv.models.Projeto;
import com.suchorski.sbbv.models.Projeto_;

public class ProjetoDAO extends GenericDAO<Projeto, Long> {
	
	public ProjetoDAO() {
		super(Projeto.class);
	}
	
	@Override
	public List<Projeto> list() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Projeto> criteriaQuery = criteriaBuilder.createQuery(Projeto.class);
		Root<Projeto> root = criteriaQuery.from(Projeto.class);
		criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get(Projeto_.projeto)));
		TypedQuery<Projeto> typedQuery = getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
