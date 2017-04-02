package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			
			//enviar para o jsp
			request.setAttribute("empresa", empresa);
			
			RequestDispatcher view = request.getRequestDispatcher("Cadastrar.jsp");
			view.forward(request, response);
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
			
			//enviar para o jsp
			request.setAttribute("empresa", empresa);
			
			RequestDispatcher view = request.getRequestDispatcher("Alterar.jsp");
			view.forward(request, response);
		}
		
		// EXCLUIR EMPRESA
		if(acao.equals("Deletar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Empresa empresa = new Empresa();
			empresa.setId(id);
			
			service.excluir(empresa);
			
			//enviar para o jsp
			request.setAttribute("empresa", empresa);
			
			RequestDispatcher view = request.getRequestDispatcher("Excluir.jsp");
			view.forward(request, response);
		}
		
		// CARREGAR EMPRESA
		if(acao.equals("Consultar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Empresa copia = service.carregar(id);
			
			//enviar para o jsp
			request.setAttribute("empresa", copia);
			
			RequestDispatcher view = request.getRequestDispatcher("Carregar.jsp");
			view.forward(request, response);
		}
	}
}
