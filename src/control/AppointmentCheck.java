package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.oracle.webservices.internal.api.EnvelopeStyle.Style;

import daofiles.AppointmentDao;
import daofiles.DoctorDao;
import beans.AppointmentBean;
import beans.DocBean;

/**
 * Servlet implementation class AppointmentCheck
 */
@WebServlet("/AppointmentCheck")
public class AppointmentCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		   out.println("<html>");
		   out.println("<head><title>My Appointments</title></head>");
	       out.print("<body bgcolor='#ADD8E6'>");
	      
	     response.setContentType("text/html");
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
         response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
         response.setHeader("Expires", "0");  	//	Proxies 	
         
					HttpSession session=request.getSession(true);
		            		           
			       if(session.getAttribute("email")==null){
 					response.sendRedirect("DoctorLogin.jsp");
 					return;
 					}
 			       else	{
 					String email=(String) session.getAttribute("email");
 					out.println("Hello ,  "+email);
 					}
		
		  
	       String email=(String) session.getAttribute("email");
	       String idParam = request.getParameter("id");
	       if (idParam == null || idParam.trim().isEmpty()) {
	           out.print("<center><h3> Error: Doctor ID is missing </h3><br><a href='DoctorHome.jsp'>Back</a></center></body></html>");
	           return;
	       }
	       int id;
	       try {
	           id = Integer.parseInt(idParam);
	       } catch (NumberFormatException e) {
	           out.print("<center><h3> Error: Invalid Doctor ID </h3><br><a href='DoctorHome.jsp'>Back</a></center></body></html>");
	           return;
	       }
	       out.print("<center> <h1 style='background-color:lightgreen' >My Appointments</h1>");
	       out.print("<table border='1px solid black' height='10%' width='70%'><tr>");
	       out.print("<th style='background-color:#2874A6; color:white;'>Patient Name</th>	<th style='background-color:#2874A6; color:white;'>Email</th> 	<th style='background-color:#2874A6; color:white;'>Contact</th>");
	       out.print("<th style='background-color:#2874A6; color:white;'>Age</th> 	<th style='background-color:#2874A6; color:white;'>Date</th> 		<th style='background-color:#2874A6; color:white;'>Specialty</th>");
	       out.print("<th style='background-color:#2874A6; color:white;'>Description</th>		<th style='background-color:#2874A6; color:white;'>Cancel</th></tr>");
	       
	       DocBean dbe = DoctorDao.getDoctor(id,email);
	       if(dbe != null && (id == dbe.getId() || email.equals(dbe.getEmail())))	{
	       ArrayList<AppointmentBean> list=AppointmentDao.getAppointById(id);
	       for (AppointmentBean apps : list) {
	    	   out.print("<tr style='background-color:white'><td>"+apps.getName()+"</td><td>"+apps.getEmail()+"</td>");
		       out.print("<td>"+apps.getContact()+"</td><td>"+apps.getAge()+"</td>");
		       out.print("<td>"+apps.getDay()+"</td><td>"+apps.getSpecialty() +"</td>");
		       out.print("<td>"+apps.getDescription()+"</td>");
		       out.print("<td><a href='CancelAppointment?id="+apps.getApid()+"'>Cancel</a></td></tr>");}
	       }
	       else	{
	    	   out.print("<h3> Please Enter your Correct Id </h3>");
	       }
		   out.print("</table>");
		   out.print("<br><a href='DoctorHome.jsp' style='padding: 10px 20px; background: #2874A6; color: white; text-decoration: none; border-radius: 5px;'>Back to Dashboard</a>");
		  
		   out.print("</div></center>");
		  
	       out.print("</body>");
	   	   out.print("</html>");
	   	
	   	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
