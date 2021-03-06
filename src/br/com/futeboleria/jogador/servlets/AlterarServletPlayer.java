package br.com.futeboleria.jogador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.futeboleria.jogador.bean.Player;
import br.com.futeboleria.jogador.dao.PlayerDAO;

@SuppressWarnings("unused")
@WebServlet("/alterarPlayer")
public class AlterarServletPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterarServletPlayer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String pagina = "";
		
		PlayerDAO dao = new PlayerDAO();
		
		Integer id = ((Player)session.getAttribute("player")).getId();
		
		Player p = dao.getByPK(id);
		
		pagina = "editaPlayer.jsp";
		
		request.setAttribute("player", p);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

}
