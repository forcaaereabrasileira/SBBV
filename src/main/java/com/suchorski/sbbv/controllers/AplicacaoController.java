package com.suchorski.sbbv.controllers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.suchorski.sbbv.utils.HibernateService;

import lombok.extern.jbosslog.JBossLog;


@Named("app")
@ApplicationScoped
@JBossLog
public class AplicacaoController {
	
	public static final String CONTEXT = "sbbv";
	public static final String NAME = "SBBV";
	public static final String TITLE = "Sistema de Busca da Biblioteca Virtual";
	public static final String VERSION = "BETA";
	
	@PostConstruct
	public void init() {
		log.debug("Initializing Application class...");
		HibernateService.startup();
	}
	
	@PreDestroy
	public void destroy() {
		HibernateService.shutdown();
		log.debug("Destroying Application class...");
	}
	
	public String getContext() {
		return CONTEXT;
	}
	
	public String getName() {
		return NAME;
	}
	
	public String getTitle() {
		return TITLE;
	}
	
	public String getVersion() {
		return VERSION;
	}
	
}
