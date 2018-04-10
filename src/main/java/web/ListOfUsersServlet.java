package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.UserModel;
import repositories.UserRepository;
import repositories.DummyUserRepository;

/**
 * Servlet implementation class ListOfUsersServlet
 */
@WebServlet("/ListOfUsers")
public class ListOfUsersServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	private UserRepository repository;

	public void init(ServletConfig config) throws ServletException {
		repository = new DummyUserRepository();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response = preamble(response);
		HttpSession session = request.getSession();
		Object userModel = session.getAttribute("conf");

		
		
		if(userModel == null || !(userModel instanceof UserModel)) {
			response.getWriter().println("U¿ytkownik niezalogowany! <a href=\"/login\">Zaloguj</a>");
		} else if(((UserModel)userModel).getAccessLevel() < UserModel.ADMIN){
			response.getWriter().println("<h1>Nie masz konta ADMIN!</h1>");
		}
		
        response.getWriter().println("<table><tr><th>User</th><th>Email</th><th>Access</th></tr>");
		for(UserModel user: repository.getAllUsers()) {
			response.getWriter().println(
				"<tr><td>"+user.getUsername()+
				"</td><td>"+user.getEmail()+
				"</td><td>"+user.getAccessLevel()
				+"</td></tr>"
			);
		}
		response.getWriter().println("</table>");
	}

}
