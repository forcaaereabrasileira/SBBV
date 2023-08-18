package com.suchorski.sbbv.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.github.adminfaces.template.session.AdminSession;
import com.suchorski.sbbv.oauth.ResourceUserData;
import com.suchorski.sbbv.oauth.ScatiAPI;

import lombok.Getter;
import lombok.extern.jbosslog.JBossLog;

@Named("sessao")
@SessionScoped
@Specializes
@JBossLog
public class SessaoController extends AdminSession implements Serializable {
	
	private static final long serialVersionUID = 3216334435055422963L;

	@Getter private ResourceUserData usuario;
	@Getter private ScatiAPI api;
	
	@PostConstruct
	public void init() {
		log.info("Initializing session...");
		api = new ScatiAPI().setPublicKey(ScatiAPI.CLIENT_PUBLIC).setPrivateKey(ScatiAPI.CLIENT_SECRET).setRedirectUri(String.format("http://%s/sbbv/callback", ScatiAPI.URI_DOMAIN)).setScope(ScatiAPI.SCOPE);
		usuario = api.getResourceUserData();
	}
	
	@PreDestroy
	public void destroy() {
		log.info("Finalized session");
	}
	
	public String getDisplayName() {
		return String.format("%s %s [%s]", usuario.getPatente(), usuario.getNomeGuerra(), usuario.getOm());
	}
	
	public void setToken(String token) {
		api.setToken(token);
		atualizaUsuario();
	}
	
	public void atualizaUsuario() {
		usuario = api.getResourceUserData();
	}
	
	public void redirect() throws IOException {
		if (api.getToken() == null || api.getToken().isEmpty()) {
			Faces.redirect(api.generateLogonUri());
		} else {
			atualizaUsuario();
			if (usuario == null || !usuario.isValid()) {
				api.setToken(null);
				Faces.invalidateSession();
				Faces.redirect(api.generateLogonUri());
			} else {
				Faces.redirect("publicacoes.xhtml?faces-redirect=true");
			}
		}
	}
	
	public void logoff() throws IOException {
		api.setToken(null);
		usuario = null;
		Faces.invalidateSession();
		Faces.redirect("publicacoes.xhtml?faces-redirect=true");
	}
	
	public boolean isLogado() {
		atualizaUsuario();
		return usuario != null && usuario.isValid();
	}
	
	public boolean isEditor() {
		return isLogado() && usuario.getPerfis().stream().anyMatch(p -> p.equalsIgnoreCase(ScatiAPI.SCOPE));
	}
	
	@Override
	public boolean isLoggedIn() {
		return true;
	}

}
