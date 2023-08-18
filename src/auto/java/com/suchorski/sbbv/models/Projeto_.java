package com.suchorski.sbbv.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-05T11:13:37.497-0300")
@StaticMetamodel(Projeto.class)
public class Projeto_ {
	public static volatile SingularAttribute<Projeto, Long> id;
	public static volatile SingularAttribute<Projeto, String> projeto;
	public static volatile ListAttribute<Projeto, Publicacao> publicacaos;
}
