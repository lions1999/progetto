package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import logic.dao.SqlDAO;

@WebServlet("/Login")
public class LoginControllerServlet extends HttpServlet 
{
	public static final long serialVersionUID = 1L;
	
	public LoginControllerServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		SqlDAO dao = new SqlDAO();
		
		
		try {
			if(dao.checkLogin(email, pass))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", email);
				session.setAttribute("password", pass);
				String role = dao.checkRole(email).toString();
				session.setAttribute("role", role);
				int condominiumCode = dao.checkCondominiumCode(email);
				session.setAttribute("condCode", condominiumCode);
				String condominium = dao.checkCondominium(condominiumCode);
				session.setAttribute("cond", condominium);
				response.sendRedirect("HomePage.jsp");
			}
			else
			{
				response.sendRedirect("index.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}