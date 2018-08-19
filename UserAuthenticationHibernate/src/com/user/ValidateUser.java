package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hibernate.GetRTCIUIUser;

/**
 * Servlet implementation class ValidateUser
 */
@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter(System.out);
		String vzid=request.getParameter("vzid");
		GetRTCIUIUser user=new GetRTCIUIUser();
		if(user.validateUser(vzid))
	    //if(vzid.equals("v536139"))
		{
			HttpSession session= request.getSession();
			session.setAttribute("vzid_session",vzid);
			response.sendRedirect("HomePage.jsp");
		}
		else
		{
			response.sendRedirect("ErrorPage.jsp");
		}
	}
	
	public static void main(String arg[])
	{
		GetRTCIUIUser user=new GetRTCIUIUser();
		if(user.validateUser("v536139"))
		{
			System.out.println("vzid valid");
		}
		else
		{
			System.out.println("vzid not valid");
		}
		
	}

}
