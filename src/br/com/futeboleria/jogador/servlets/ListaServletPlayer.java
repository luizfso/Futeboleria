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

import br.com.futeboleria.jogador.bean.Player;
import br.com.futeboleria.jogador.dao.PlayerDAO;

@WebServlet("/listarPlayers")
public class ListaServletPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaServletPlayer() {
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
			pagina = "listaPlayers.jsp";
			
			PlayerDAO dao = new PlayerDAO();
			
			ArrayList<Player> players = null;
			
			if(buscar != null){
				String nome = request.getParameter("txtNome");
				players = (ArrayList<Player>)dao.getByNome(nome);
			}
			else
				players = (ArrayList<Player>)dao.getAll();
			
			request.setAttribute("listaP", players);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

}
