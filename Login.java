package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		
		if(email.equals("zach@mail.com") && password.equals("password")){
			HttpSession session = request.getSession();
			session.setAttribute("sesname", email);
			RequestDispatcher rd = request.getRequestDispatcher("profile.html");
			rd.forward(request, response);
		}
		else {
			response.getWriter().println("Unable to log in");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
		}
	
	}

}
