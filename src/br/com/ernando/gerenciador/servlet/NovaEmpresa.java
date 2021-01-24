package br.com.ernando.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ernando.gerenciador.model.DataBase;
import br.com.ernando.gerenciador.model.Empresa;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeEmpresa = req.getParameter("nome");
		String paramData = req.getParameter("data");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		try {
			empresa.setDataAbertura(sdf.parse(paramData));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		DataBase.adicionaEmrpesa(empresa);
		
		req.setAttribute("nomeEmpresa", empresa.getNome());
		resp.sendRedirect("listarEmpresas");
		
//		RequestDispatcher rd = req.getRequestDispatcher("/listarEmpresas");
//		rd.forward(req, resp);
	}
	
}
