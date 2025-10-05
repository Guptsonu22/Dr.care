package control;

import java.io.IOException;

import daofiles.AdminDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLog
 * Handles admin authentication and session management
 */
@WebServlet("/AdminLog")
public class AdminLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLog() {
        super();
    }
    
    /**
     * Handles POST requests for admin login
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html;charset=UTF-8");
		
		// Get login parameters
		String email = request.getParameter("email");  
		String password = request.getParameter("password");
		
		// Validate input parameters
		if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty()) {
			request.setAttribute("errorMessage", "Email and password are required");
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request, response);
			return;
		}
		
		try {
			// Validate admin credentials
			if (AdminDao.validate(email, password)) {
				// Create session and store admin email
				HttpSession session = request.getSession(true);
				session.setAttribute("adminEmail", email);
				session.setAttribute("userType", "admin");
				
				// Redirect to admin home page
				response.sendRedirect("AdminHome.jsp");
			} else {
				// Invalid credentials - redirect back to login with error
				request.setAttribute("errorMessage", "Invalid email or password");
				RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// Handle any database or system errors
			request.setAttribute("errorMessage", "Login failed due to system error. Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}
}
	

