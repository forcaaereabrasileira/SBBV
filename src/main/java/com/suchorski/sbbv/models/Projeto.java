package com.suchorski.sbbv.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
public class Projeto implements Serializable {

	private static final long serialVersionUID = -5767980351984662719L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;

	private String projeto;

	@OneToMany(mappedBy="projeto")
	private List<Publicacao> publicacaos;
	
	@Override
	public String toString() {
		return projeto;
	}

}