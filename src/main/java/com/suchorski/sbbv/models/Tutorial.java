package com.suchorski.sbbv.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
public class Tutorial implements Serializable {

	private static final long serialVersionUID = 4632228171430658505L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;

	private String titulo;

	private String url;

	@ManyToMany
	@JoinTable(
		name="publicacao_has_tutorial"
		, joinColumns={
			@JoinColumn(name="tutorial_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="publicacao_id")
			}
		)
	private List<Publicacao> publicacaos;

}