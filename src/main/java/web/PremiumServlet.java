package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.UserModel;

/**
 * Servlet implementation class PremiumServlet
 */
@WebServlet("/PremiumServlet")
public class PremiumServlet extends UserServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PremiumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object userModel = session.getAttribute("conf");
		response = preamble(response);
		
		
		if(userModel == null || !(userModel instanceof UserModel)) {
			response.getWriter().println("U¿ytkownik niezalogowany! <a href=\"/login\">Zaloguj</a>");
		} else if(((UserModel)userModel).getAccessLevel() < UserModel.PREMIUM){
			response.getWriter().println("<h1>Nie masz konta PREMIUM!</h1>");
		} else
		{
			response.getWriter().println("<h1>Witaj na stronie PREMIUM</h1>");
			response.getWriter().println("<img src=\"http://i0.kym-cdn.com/photos/images/original/000/836/624/bc8.jpg\"/>");
		}
	}

}
