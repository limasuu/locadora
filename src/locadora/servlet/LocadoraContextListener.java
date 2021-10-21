package locadora.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import locadora.negocio.Locadora;

@WebListener
public class LocadoraContextListener implements ServletContextListener {

	public static final String NOME_SISTEMA= "sistema";   

	public void contextInitialized(ServletContextEvent evento)  { 

		ServletContext contexto= evento.getServletContext();

		try {    		
			Locadora locadora= new Locadora();
			contexto.setAttribute(NOME_SISTEMA, locadora);

		}catch(Exception e) {
			System.out.println("O sistema de locadora não pode ser publicado no contexto: "
					+ e.getMessage());
		}   
	}	

	public void contextDestroyed(ServletContextEvent evento)  { 

		ServletContext contexto= evento.getServletContext();
		Locadora locadora= (Locadora) contexto.getAttribute(NOME_SISTEMA);

		if(locadora != null)
			locadora.fechar();

		contexto.removeAttribute(NOME_SISTEMA);
	}
}
