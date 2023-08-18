package com.suchorski.sbbv.controllers;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("login")
@RequestScoped
public class LoginController {
	
	@Inject private SessaoController sessao;
	
	public void logonRedirect() throws IOException {
		sessao.redirect();
	}
	
	public void logoff() throws IOException {
		sessao.logoff();
	}

}
