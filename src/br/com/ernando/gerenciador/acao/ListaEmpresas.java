package br.com.ernando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ernando.gerenciador.model.DataBase;

public class ListaEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		request.setAttribute("empresas",  DataBase.getEmpresas());
		return "forward:listarEmpresa.jsp";
	}

}
