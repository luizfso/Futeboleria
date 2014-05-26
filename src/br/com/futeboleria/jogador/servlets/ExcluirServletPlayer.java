package br.com.futeboleria.jogador.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.futeboleria.jogador.bean.Player;
import br.com.futeboleria.jogador.dao.PlayerDAO;

@WebServlet("/excluirPlayers")
public class ExcluirServletPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirServletPlayer() {
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
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		PlayerDAO dao = new PlayerDAO();
		
		dao.delete(id);
		
		ArrayList<Player> players = (ArrayList<Player>) dao.getAll();
		request.setAttribute("listaP", players);
		
		pagina = "listaPlayers.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
