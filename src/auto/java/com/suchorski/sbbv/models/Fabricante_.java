package com.suchorski.sbbv.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-05T11:13:37.476-0300")
@StaticMetamodel(Fabricante.class)
public class Fabricante_ {
	public static volatile SingularAttribute<Fabricante, Long> id;
	public static volatile SingularAttribute<Fabricante, String> fabricante;
	public static volatile ListAttribute<Fabricante, Publicacao> publicacaos;
}
