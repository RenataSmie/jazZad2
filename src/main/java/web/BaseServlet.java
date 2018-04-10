package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HttpServletResponse preamble(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
        		"<div><a href=\"http://localhost:8080/UserProfile\">Profil</a>|"
        		+ "<a href=\"http://localhost:8080/login\">Login</a>|"
        		+"<a href=\"http://localhost:8080/\">Rejestracja</a>|"
        		+"<a href=\"http://localhost:8080/PremiumServlet\">Premium</a>|"+
        		"<a href=\"http://localhost:8080/ListOfUsers\">Lista</a></div>"
        );
        return response;
	}
}
