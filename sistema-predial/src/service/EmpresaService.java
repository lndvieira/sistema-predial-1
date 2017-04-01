package service;

import java.util.List;

import dao.EmpresaDAO;
import model.Empresa;

public class EmpresaService {
	
	EmpresaDAO dao = new EmpresaDAO();
	
	// INCLUIR EMPRESA
	public void incluir(Empresa empresa) {
		dao.incluir(empresa);
	}
	
	// ATUALIZAR EMPRESA
	public void atualizar(Empresa empresa) {
		dao.atualizar(empresa);
	}
	
	// EXCLUIR EMPRESA
	public void excluir(Empresa empresa) {
		dao.excluir(empresa);
	}
	
	// CARREGAR EMPRESA
	public Empresa carregar(int id) {
		return dao.carregar(id);
	}
	
	// CARREGAR TODAS AS EMPRESAS
	public List<Empresa> carregarTudo() {
		return dao.carregarTudo(); 
	}
}
