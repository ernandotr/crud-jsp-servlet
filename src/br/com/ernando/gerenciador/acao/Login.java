package br.com.ernando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ernando.gerenciador.model.DataBase;
import br.com.ernando.gerenciador.model.Usuario;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println("Logando " +login);
		
		Usuario usuario = DataBase.existeUsuario(login, senha);
		
		if(usuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}
		return "redirect:entrada?acao=LoginForm";
	}

}
