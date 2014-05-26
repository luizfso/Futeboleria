package br.com.futeboleria.jogador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.futeboleria.jogador.bean.Player;
import br.com.futeboleria.jogador.dao.PlayerDAO;

@WebServlet("/loginplayer")
public class LoginServletPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServletPlayer() {
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
		
		String username = request.getParameter("txtLogin");
		String senha = request.getParameter("txtSenha");
		
		PlayerDAO dao = new PlayerDAO();
		Boolean logado = dao.username(username, senha);
		
		Player p = dao.getByUsername(username);
		
		request.setAttribute("player", p);
		
		if(logado)
			pagina = "homePlayer.jsp";
		else
			pagina = "erro_login.html";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
