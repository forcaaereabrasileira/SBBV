package com.suchorski.sbbv.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.suchorski.sbbv.generics.GenericDAO;
import com.suchorski.sbbv.models.Publicacao;
import com.suchorski.sbbv.models.Publicacao_;

public class PublicacaoDAO extends GenericDAO<Publicacao, Long> {
	
	public PublicacaoDAO() {
		super(Publicacao.class);
	}
	
	@Override
	public List<Publicacao> list() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Publicacao> criteriaQuery = criteriaBuilder.createQuery(Publicacao.class);
		Root<Publicacao> root = criteriaQuery.from(Publicacao.class);
		criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get(Publicacao_.numero)));
		TypedQuery<Publicacao> typedQuery = getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
