package br.com.ernando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ernando.gerenciador.acao.Acao;

//@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
		protected void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
			String paramAcao = request.getParameter("acao");
			
//			HttpSession session = request.getSession();
//			boolean usuarioNaoLogado = (session.getAttribute("usuarioLogado") == null);
//			boolean ehUmaAcaoProtegida = !(paramAcao.contentEquals("Login") || paramAcao.contentEquals("LoginForm"));
//			
//			if(ehUmaAcaoProtegida && usuarioNaoLogado) {
//				response.sendRedirect("entrada?acao=LoginForm");
//				return;
//			}
			String nomeDaClasse  = "br.com.ernando.gerenciador.acao."+paramAcao;
			
			String nome;
			try {
				Class classe = Class.forName(nomeDaClasse);
				Acao acao = (Acao) classe.newInstance();
				nome = acao.executa(request, response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
					| IOException e) {
				throw new ServletException(e);
			}
			
			String[] tipoAndEndereco = nome != null ? nome.split(":") : null;
			if(tipoAndEndereco != null && tipoAndEndereco[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoAndEndereco[1]);
				rd.forward(request, response);
			} else if(tipoAndEndereco != null){
				response.sendRedirect(tipoAndEndereco[1]);
			}
			
		}

}
