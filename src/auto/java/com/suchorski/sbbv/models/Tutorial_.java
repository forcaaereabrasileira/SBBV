package com.suchorski.sbbv.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-05T11:13:37.521-0300")
@StaticMetamodel(Tutorial.class)
public class Tutorial_ {
	public static volatile SingularAttribute<Tutorial, Long> id;
	public static volatile SingularAttribute<Tutorial, String> titulo;
	public static volatile SingularAttribute<Tutorial, String> url;
	public static volatile ListAttribute<Tutorial, Publicacao> publicacaos;
}
