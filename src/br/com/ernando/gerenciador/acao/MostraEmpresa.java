package br.com.ernando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ernando.gerenciador.model.DataBase;
import br.com.ernando.gerenciador.model.Empresa;

public class MostraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Empresa empresa = DataBase.getById(id);
		request.setAttribute("empresa", empresa);
		
		return "forward:formEditarEmpresa.jsp";
	}
}
