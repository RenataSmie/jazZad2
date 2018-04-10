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
 * Servlet implementation class AddApplicantServlet
 */
// Servlet do zapisywania danych. Po poprawnie wype³nionym formularzu dane maj¹
// byæ zapisane na serwerze (w naszym przypadku do listy w pamiêci aplikacji).

@WebServlet("/add")
public class AddApplicantServlet extends UserServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository repository;

	public void init(ServletConfig config) throws ServletException {
		repository = new DummyUserRepository();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session.getAttribute("conf") != null) {
			response.sendRedirect("profile.jsp");
		}
		UserModel application = retrieveApplicationFromRequest(request);
		UserRepository repository = new DummyUserRepository();

		repository.add(application);
		session.setAttribute("conf", application);
		response.sendRedirect("profile.jsp");
	}

	
}
