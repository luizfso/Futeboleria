package br.com.futeboleria.jogador.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.futeboleria.jogador.bean.Club;
import br.com.futeboleria.jogador.dao.CadastraClubDAO;

@WebServlet("/excluirClubs")
public class ExcluirServletCLub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirServletCLub() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pagina = "";
		
		Integer ide = Integer.parseInt(request.getParameter("ide"));
		
		CadastraClubDAO dao = new CadastraClubDAO();
		
		dao.delete(ide);
		
		ArrayList<Club> clubs = (ArrayList<Club>) dao.getAll();
		request.setAttribute("listaC", clubs);
		
		pagina = "listaClubs.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
