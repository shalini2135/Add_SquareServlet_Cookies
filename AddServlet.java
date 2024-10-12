package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	int i=Integer.parseInt(req.getParameter("num1"));
	int j=Integer.parseInt(req.getParameter("num2"));
	int k=i+j;
	//System.out.println("Addition of Two numbers:"+k);
//	 PrintWriter out=res.getWriter();
//	 out.println("Result is="+k);

	 //To call another server ,we have two options,
	 //One is Request Dispatcher and Redirectory
	 //1)We use Request Dispatcher

 //Session Management--->to share data between two servlets
// req.setAttribute("k",k);
// 
//	 RequestDispatcher rd=req.getRequestDispatcher("sq");
//	rd.forward(req, res); 
 
//	res.sendRedirect("sq?k="+k);
	//session Managemet || cookies || URL Rewriting
 //Above method is URL rewriting-->possible only when passing single value
//but passing multiple values is not possible with the URL rewriting methods
	
	//Session---> is provided by the Tomcat webserver
	
//	HttpSession session=req.getSession();
//	session.setAttribute("k", k);
//	res.sendRedirect("sq");
	
//what is cookie?
	//whenever we send the request to the server and a server will send you a response
	//now in that response object  so the response object which is coming from the server
	// will have a cookie.
Cookie 	cookie=new Cookie("k",k+"");
res.addCookie(cookie);//sending cookie to client
res.sendRedirect("sq");//client again send the request to the server
	
}
}
