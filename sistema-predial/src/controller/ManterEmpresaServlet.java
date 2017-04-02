package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import model.Horario;
import service.EmpresaService;

/**
 * Servlet implementation class ManterEmpresaServlet
 */
@WebServlet("/ManterEmpresaServlet.do")
public class ManterEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterEmpresaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
	
		EmpresaService service = new EmpresaService();
		
		PrintWriter out = response.getWriter();
		
		// CADASTRAR EMPRESA
		if(acao.equals("Cadastrar")) {	
			String rSocial = request.getParameter("rsocial");
			String cnpj = request.getParameter("cnpj");
			int conj = Integer.parseInt(request.getParameter("conj"));
			String temp = request.getParameter("temp") + "º";
			String entradaFunc = request.getParameter("entradaFunc");
			String saidaFunc = request.getParameter("saidaFunc");
			String entradaAr = request.getParameter("entradaAr");
			String saidaAr = request.getParameter("saidaAr");
			
			Horario horaFunc = new Horario(entradaFunc, saidaFunc);
			Horario horaAr = new Horario(entradaAr, saidaAr);
			
			Empresa empresa = new Empresa(conj, rSocial, cnpj, temp, horaFunc, horaAr);
			 
			service.incluir(empresa);
			
			String html = "<!DOCTYPE html><html lang=\"pt-br\"><head><meta charset=\"UTF-8\"><title>Cadastrar Empresa</title></head><body><p>Empresa cadastrada com sucesso! <strong>ID: " + empresa.getId() +"</strong></p><br><br><a href=\"predial.html\"><button type=\"button\">Voltar</button></a></body></html>";
			
			out.println(html);
		}
		
		// ALTERAR EMPRESA
		if(acao.equals("Alterar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String rSocial = request.getParameter("rsocial");
			String cnpj = request.getParameter("cnpj");
			int conj = Integer.parseInt(request.getParameter("conj"));
			String temp = request.getParameter("temp");
			String entradaFunc = request.getParameter("entradaFunc");
			String saidaFunc = request.getParameter("saidaFunc");
			String entradaAr = request.getParameter("entradaAr");
			String saidaAr = request.getParameter("saidaAr");
			
			Horario horaFunc = new Horario(entradaFunc, saidaFunc);
			Horario horaAr = new Horario(entradaAr, saidaAr);
			
			Empresa empresa = new Empresa(conj, rSocial, cnpj, temp, horaFunc, horaAr);
			empresa.setId(id);
			
			service.atualizar(empresa);
			
			String html = "<!DOCTYPE html><html lang=\"pt-br\"><head><meta charset=\"UTF-8\"><title>Alterar Empresa</title></head><body><p>Empresa alterada com sucesso!</p><table border=\"1\"><thead><th>ID:</th><th>Razão Social:</th><th>CNPJ:</th><th>Conjunto:</th><th>Temperatura:</th><th>Horário de Funcionamento:</th><th>Horário de Ar-Condicionado:</th></thead><tbody><tr><td>" + empresa.getId() + "</td><td>" + empresa.getRazaoSocial() + "</td><td>"+ empresa.getCnpj() +"</td><td>" + empresa.getConjunto() + "</td><td>" + empresa.getTemperatura() + "</td><td>" + empresa.getHoraFuncionamento() + "</td><td>" + empresa.getHoraArCondicionado() + "</td></tr></tbody></table><br><br><a href=\"predial.html\"><button type=\"button\">Voltar</button></a></body></html>";
			
			out.println(html);
		}
		
		// EXCLUIR EMPRESA
		if(acao.equals("Deletar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Empresa empresa = new Empresa();
			empresa.setId(id);
			
			service.excluir(empresa);
			
			String html = "<!DOCTYPE html><html lang=\"pt-br\"><head><meta charset=\"UTF-8\"><title>Remover Empresa</title></head><body><p>Empresa removida com sucesso! <strong>ID: " + empresa.getId() +"</strong></p><br><br><a href=\"predial.html\"><button type=\"button\">Voltar</button></a></body></html>";
			
			out.println(html);
		}
		
		// CARREGAR EMPRESA
		if(acao.equals("Consultar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Empresa copia = service.carregar(id);
			
			String html = "<!DOCTYPE html><html lang=\"pt-br\"><head><meta charset=\"UTF-8\"><title>Carregar Empresa</title></head><body><p>Empresa carregada com sucesso!</p><table border=\"1\"><thead><th>ID:</th><th>Razão Social:</th><th>CNPJ:</th><th>Conjunto:</th><th>Temperatura:</th><th>Horário de Funcionamento:</th><th>Horário de Ar-Condicionado:</th></thead><tbody><tr><td>" + copia.getId() + "</td><td>" + copia.getRazaoSocial() + "</td><td>"+ copia.getCnpj() +"</td><td>" + copia.getConjunto() + "</td><td>" + copia.getTemperatura() + "</td><td>" + copia.getHoraFuncionamento() + "</td><td>" + copia.getHoraArCondicionado() + "</td></tr></tbody></table><br><br><a href=\"predial.html\"><button type=\"button\">Voltar</button></a></body></html>";
			
			out.println(html);
		}
	}
}
