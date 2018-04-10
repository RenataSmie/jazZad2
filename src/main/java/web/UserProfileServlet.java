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
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfile")
public class UserProfileServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private UserRepository repository;

	public void init(ServletConfig config) throws ServletException {
		repository = new DummyUserRepository();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response = preamble(response);
		HttpSession session = request.getSession();
		
		UserModel sessionApplication = (UserModel) session.getAttribute("conf");
		UserModel application = repository.getRegistrationByEmailAddress(sessionApplication.getEmail());
		
		if(application == null) {
			response.sendRedirect("logging.jsp");
		} else {
			response.sendRedirect("profile.jsp");
		}

	}

}
