package com.suchorski.sbbv.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.suchorski.sbbv.daos.FabricanteDAO;
import com.suchorski.sbbv.daos.ProjetoDAO;
import com.suchorski.sbbv.daos.PublicacaoDAO;
import com.suchorski.sbbv.models.Fabricante;
import com.suchorski.sbbv.models.Projeto;
import com.suchorski.sbbv.models.Publicacao;

import lombok.Getter;
import lombok.Setter;

@Named("publicacoes")
@ViewScoped
public class PublicacoesController implements Serializable {

	private static final long serialVersionUID = -7389653502266291417L;

	private PublicacaoDAO publicacaoDAO;
	private ProjetoDAO projetoDAO;
	private FabricanteDAO fabricanteDAO;
	
	@Getter private List<Publicacao> publicacoes;
	@Getter private List<Projeto> projetos;
	@Getter private List<Fabricante> fabricantes;
	
	@Getter @Setter Publicacao publicacao;

	@PostConstruct
	public void init() {
		publicacaoDAO = new PublicacaoDAO();
		publicacoes = publicacaoDAO.list();
		projetoDAO = new ProjetoDAO();
		projetos = projetoDAO.list();
		fabricanteDAO = new FabricanteDAO();
		fabricantes = fabricanteDAO.list();
	}

	@PreDestroy
	public void destroy() {
		projetoDAO.close();
		fabricanteDAO.close();
		publicacaoDAO.close();
	}
	
	public void salvar() {
		publicacao.setUltimaAtualizacao(new Date());
		publicacaoDAO.update(publicacao);
		Messages.create("Sucesso!").detail("Publicação atualizada.").add();
	}

}
