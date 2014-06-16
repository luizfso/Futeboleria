package br.com.futeboleria.jogador.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.futeboleria.jogador.bean.Club;
import br.com.futeboleria.jogador.dao.ClubDAO;

@WebServlet("/novoCadastroClub")
public class NovoServletClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NovoServletClub() {
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
		
		String id = request.getParameter("id");
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String endereco = request.getParameter("txtEndereco");
		String bairro = request.getParameter("txtBairro");
		String cidade = request.getParameter("txtCidade");
		String telefone = request.getParameter("txtTelefone");
		String cpf = request.getParameter("txtCpf");
		
		String voltar = request.getParameter("btnVoltar");
		
		if(voltar != null){
			pagina = "bemvindo.jsp";
		}
		else{
			
			Club c = new Club();
			c.setUsername(username);
			c.setPassword(password);
			c.setNome(nome);
			c.setEmail(email);
			c.setEndereco(endereco);
			c.setBairro(bairro);
			c.setCidade(cidade);
			c.setTelefone(telefone);
			c.setCpf(cpf);
			
			ClubDAO dao = new ClubDAO();
		
				dao.insert(c);
				c = dao.getByUsername(username);
				request.setAttribute("club", c);
				session.setAttribute("club", c);
				pagina = "homeClub.jsp";
			
			request.setAttribute("club", c);
			
			ArrayList<Club> clubs = (ArrayList<Club>) dao.getAll();
			request.setAttribute("listaC", clubs);
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}
}
