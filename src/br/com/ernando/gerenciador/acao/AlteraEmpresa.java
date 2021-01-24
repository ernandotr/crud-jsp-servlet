package br.com.ernando.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ernando.gerenciador.model.DataBase;
import br.com.ernando.gerenciador.model.Empresa;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nomeEmpresa = req.getParameter("nome");
		String paramData = req.getParameter("data");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Empresa empresa = DataBase.getById(id);
		empresa.setNome(nomeEmpresa);
		try {
			empresa.setDataAbertura(sdf.parse(paramData));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		req.setAttribute("nomeEmpresa", empresa.getNome());
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
