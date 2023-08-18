package com.suchorski.sbbv.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
public class Publicacao implements Serializable {

	private static final long serialVersionUID = -6387502979086936121L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="atualizacao_data")
	private Date atualizacaoData;

	@Column(name="atualizacao_revisao")
	private String atualizacaoRevisao;

	private String descricao;

	@Column(name="link_externo")
	private boolean linkExterno;

	private String numero;

	private String titulo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ultima_atualizacao")
	private Date ultimaAtualizacao;

	private String url;

	@OneToMany(mappedBy="publicacao")
	private List<Pn> pns;

	@ManyToOne
	private Fabricante fabricante;

	@ManyToOne
	private Projeto projeto;

	@ManyToMany(mappedBy="publicacaos")
	private List<Tutorial> tutorials;

	public Pn addPn(Pn pn) {
		getPns().add(pn);
		pn.setPublicacao(this);

		return pn;
	}

	public Pn removePn(Pn pn) {
		getPns().remove(pn);
		pn.setPublicacao(null);

		return pn;
	}

}