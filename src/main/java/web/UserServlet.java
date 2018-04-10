package web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import domain.UserModel;


public class UserServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected UserModel retrieveApplicationFromRequest(HttpServletRequest request) {
		UserModel result = new UserModel(
			request.getParameter("username"),
			request.getParameter("password"),
			request.getParameter("email"),
			0
		);
		
		return result;
	}

}