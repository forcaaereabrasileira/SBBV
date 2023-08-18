package com.suchorski.sbbv.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-05T11:13:37.510-0300")
@StaticMetamodel(Publicacao.class)
public class Publicacao_ {
	public static volatile SingularAttribute<Publicacao, Long> id;
	public static volatile SingularAttribute<Publicacao, Date> atualizacaoData;
	public static volatile SingularAttribute<Publicacao, String> atualizacaoRevisao;
	public static volatile SingularAttribute<Publicacao, String> descricao;
	public static volatile SingularAttribute<Publicacao, Boolean> linkExterno;
	public static volatile SingularAttribute<Publicacao, String> numero;
	public static volatile SingularAttribute<Publicacao, String> titulo;
	public static volatile SingularAttribute<Publicacao, Date> ultimaAtualizacao;
	public static volatile SingularAttribute<Publicacao, String> url;
	public static volatile ListAttribute<Publicacao, Pn> pns;
	public static volatile SingularAttribute<Publicacao, Fabricante> fabricante;
	public static volatile SingularAttribute<Publicacao, Projeto> projeto;
	public static volatile ListAttribute<Publicacao, Tutorial> tutorials;
}
