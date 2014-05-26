package br.com.futeboleria.jogador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.futeboleria.jogador.bean.Club;
import br.com.futeboleria.jogador.dao.ClubDAO;

@WebServlet("/listarClubs")
public class ListaServletClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaServletClub() {
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
		
		String voltar = request.getParameter("btnVoltar");
		String buscar = request.getParameter("btnBuscar");
		
		if(voltar != null){
			pagina = "menu.html";
		}
		else{
			pagina = "listaClubs.jsp";
			
			ClubDAO dao = new ClubDAO();
			
			ArrayList<Club> clubs = null;
			
			if(buscar != null){
				String nomee = request.getParameter("txtNomee");
				clubs = (ArrayList<Club>)dao.getByNomee(nomee);
			}
			else
				clubs = (ArrayList<Club>)dao.getAll();
			
			request.setAttribute("listaC", clubs);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

}
