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

import br.com.futeboleria.jogador.bean.Player;
import br.com.futeboleria.jogador.dao.PlayerDAO;

@WebServlet("/novoCadastroPlayer")
public class NovoServletPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NovoServletPlayer() {
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
			
			Player p = new Player();
			p.setUsername(username);
			p.setPassword(password);
			p.setNome(nome);
			p.setEmail(email);
			p.setEndereco(endereco);
			p.setBairro(bairro);
			p.setCidade(cidade);
			p.setTelefone(telefone);
			p.setCpf(cpf);
			
			PlayerDAO dao = new PlayerDAO();
			
				dao.insert(p);
				p = dao.getByUsername(username);
				request.setAttribute("player", p);
				session.setAttribute("player", p);
				pagina = "homePlayer.jsp";
			
			
			request.setAttribute("player", p);
			
			ArrayList<Player> players = (ArrayList<Player>) dao.getAll();
			request.setAttribute("listaP", players);
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}
}
