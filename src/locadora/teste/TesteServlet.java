package locadora.teste;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TesteServlet")
public class TesteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter saida= response.getWriter();

		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	

		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Teste</title>");	
		saida.write("</head>");			

		saida.write("<body>");		

		saida.write("O atributo \"sistema\" existe no contexto? " +
				(getServletContext().getAttribute("sistema") != null));

		saida.write("</body>");
		saida.write("</html>");

		saida.close();			
	}
}
