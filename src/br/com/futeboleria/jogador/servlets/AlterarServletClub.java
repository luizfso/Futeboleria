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

import br.com.futeboleria.jogador.bean.Club;
import br.com.futeboleria.jogador.dao.ClubDAO;

@SuppressWarnings("unused")
@WebServlet("/alterarClub")
public class AlterarServletClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterarServletClub() {
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
		
		ClubDAO dao = new ClubDAO();
		
		Integer id = ((Club)session.getAttribute("club")).getId();
		
		Club c = dao.getByPK(id);
		
		pagina = "editaClub.jsp";
		
		request.setAttribute("club", c);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

}
