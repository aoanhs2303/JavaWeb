package luc.trannhu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import luc.models.Database;

/**
 * Servlet implementation class Authentication
 */
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		PrintWriter writer = response.getWriter();

		Database db = new Database();
		if(db.checkUser(user, pass)) {
			for(Cookie c: request.getCookies()) {
				System.out.println(c.getName());
				System.out.println(c.getValue());
			}
			Cookie cookia = new Cookie("location", "VietNam");
			
			HttpSession session = request.getSession();
			session.setAttribute("username", user);
//			writer.println("hello POST" + user + " " + pass);
			RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
			//dispatcher.forward(request, response);
			request.setAttribute("imageName", "Baby");
			dispatcher.forward(request, response);
		} else {
//			writer.println("Khong duoc");
			response.sendRedirect("login.jsp");
		}
	}
	

}
