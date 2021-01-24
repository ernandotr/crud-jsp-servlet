package br.com.ernando.gerenciador.model;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DataBase {
	
	private static List<Empresa> empresas = new LinkedList<Empresa>();
	private static List<Usuario> usuarios = new LinkedList<Usuario>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa e1 = new Empresa();
		e1.setId(chaveSequencial++);
		e1.setNome("Google");
		e1.setDataAbertura(new Date());
		Empresa e2 = new Empresa();
		e2.setId(chaveSequencial++);
		e2.setNome("Amazon");
		e2.setDataAbertura(new Date());
		empresas.add(e1);
		empresas.add(e2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("ernando");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("lu");
		u2.setSenha("12345");
		usuarios.add(u1);
		usuarios.add(u2);
	}

	public static void adicionaEmrpesa(Empresa empresa) {
		System.out.println("Adicionando Empresa no Banco de dados.");
		empresa.setId(chaveSequencial++);
		empresas.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return empresas;
	}

	public static void removeEmpresa(Integer id) {
		Iterator<Empresa> it = empresas.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId().equals(id)) {
				it.remove();
			}
		}
//		empresas.remove(id-1);
		
	}

	public static Empresa getById(Integer id) {
		Iterator<Empresa> it = empresas.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId().equals(id)) {
				return empresa;
			}
		}
		return null;
	}

	public static Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
