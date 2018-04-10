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
 * Servlet implementation class LoggingServlet
 */
@WebServlet("/login")
public class LoggingServlet extends UserServlet {
	private static final long serialVersionUID = 1L;

	private UserRepository repository;

	public void init(ServletConfig config) throws ServletException {
		repository = new DummyUserRepository();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session.getAttribute("conf") != null) {
			response.sendRedirect("profile.jsp");
			return;
		}
		response = preamble(response);
		UserModel application = retrieveApplicationFromRequest(request);
		if(application.getUsername() == null) {
			response.sendRedirect("logging.jsp");
			return;
		}
		UserModel theOther = repository.getUserByLogin(application.getUsername());

		if(theOther == null || !application.getPassword().equals(theOther.getPassword())) {
			System.out.println(application);
			System.out.println(theOther);
			response.sendRedirect("logging.jsp");
		} else {
			session.setAttribute("conf", application);
			response.sendRedirect("profile.jsp");
		}
	}
}
