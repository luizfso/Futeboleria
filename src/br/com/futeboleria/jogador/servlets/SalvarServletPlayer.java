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
import br.com.futeboleria.jogador.dao.CadastraPlayerDAO;

@WebServlet("/salvarCadastroPlayer")
public class SalvarServletPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalvarServletPlayer() {
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
			
			
			CadastraPlayerDAO dao = new CadastraPlayerDAO();
			
			if(id.equals("")){
				dao.insert(p);
			}
			else{
				p.setId(Integer.parseInt(id));
				dao.update(p);
			}
			
			ArrayList<Player> players = (ArrayList<Player>) dao.getAll();
			request.setAttribute("listaP", players);
			
			pagina = "listaPlayers.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}
}
