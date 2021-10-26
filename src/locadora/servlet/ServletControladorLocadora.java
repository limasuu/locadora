package locadora.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import locadora.negocio.CarrinhoAluguel;
import locadora.negocio.Filme;
import locadora.negocio.Locadora;
import locadora.negocio.excecao.CarrinhoException;
import locadora.negocio.excecao.FilmeNaoEncontradoException;


@WebServlet(name= "ServletControladorLocadora", urlPatterns= {"/inicio", "/catalogo"})
public class ServletControladorLocadora extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idFilme= null;
		Filme filme= null;		
		
		Locadora locadora= (Locadora) getServletContext().getAttribute(
				LocadoraContextListener.NOME_SISTEMA);
		HttpSession sessao= request.getSession();

		CarrinhoAluguel carrinho= (CarrinhoAluguel) sessao.getAttribute("carrinho");
		if(carrinho == null) {

			carrinho= new CarrinhoAluguel();
			sessao.setAttribute("carrinho", carrinho);
		}

		String acao= request.getServletPath();

		if(acao.equals("/catalogo")) {

			idFilme= request.getParameter("Add");
			if(!idFilme.equals("")) {

				try {
					filme= locadora.getFilme(idFilme);
					carrinho.adicionar(filme);
					
				} catch (CarrinhoException | FilmeNaoEncontradoException e) {
					
					System.err.println(e.getMessage());
				}
			}
		}




		String tela= acao + ".jsp";

		try {			
			request.getRequestDispatcher(tela).forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
