package com.suchorski.sbbv.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suchorski.sbbv.controllers.SessaoController;

@WebServlet("/callback")
public class CallbackServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6108701479084373083L;

	@Inject private SessaoController sessao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		if (code != null && !code.isEmpty()) {
			Cookie cookie = new Cookie("APP_TOKEN", code);
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);
			sessao.setToken(code);
			response.sendRedirect("login.xhtml");
		}
	}

}
