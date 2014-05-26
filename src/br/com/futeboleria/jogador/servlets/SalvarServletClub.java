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

@WebServlet("/salvarCadastroClub")
public class SalvarServletClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalvarServletClub() {
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
		
		String ide = request.getParameter("ide");
		String usernamee = request.getParameter("txtUsernamee");
		String passworde = request.getParameter("txtPassworde");
		String nomee = request.getParameter("txtNomee");
		String emaile = request.getParameter("txtEmaile");
		String enderecoe = request.getParameter("txtEnderecoe");
		String bairroe = request.getParameter("txtBairroe");
		String cidadee = request.getParameter("txtCidadee");
		String telefonee = request.getParameter("txtTelefonee");
		String cpfe = request.getParameter("txtCpfe");
		
		String voltar = request.getParameter("btnVoltar");
		
		if(voltar != null){
			pagina = "bemvindo.jsp";
		}
		else{
			
			Club c = new Club();
			c.setUsernamee(usernamee);
			c.setPassworde(passworde);
			c.setNomee(nomee);
			c.setEmaile(emaile);
			c.setEnderecoe(enderecoe);
			c.setBairroe(bairroe);
			c.setCidadee(cidadee);
			c.setTelefonee(telefonee);
			c.setCpfe(cpfe);
			
			CadastraClubDAO dao = new CadastraClubDAO();

			if(ide.equals("")){
				dao.insert(c);
			}	
			else{
				c.setIde(Integer.parseInt(ide));
				dao.update(c);
			}
			
			ArrayList<Club> clubs = (ArrayList<Club>) dao.getAll();
			request.setAttribute("listaC", clubs);
			
			pagina = "listaClubs.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}
}
