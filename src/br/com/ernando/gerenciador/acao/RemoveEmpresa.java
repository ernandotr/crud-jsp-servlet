package br.com.ernando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ernando.gerenciador.model.DataBase;

public class RemoveEmpresa implements Acao{

 	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException{
 		Integer id = Integer.valueOf(request.getParameter("id"));
		DataBase.removeEmpresa(id);
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
