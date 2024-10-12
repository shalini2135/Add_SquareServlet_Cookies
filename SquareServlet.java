package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.Cookie;

public class SquareServlet extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{

	
	//	int k=Integer.parseInt(req.getParameter("k"));
//	HttpSession session=req.getSession();
	// for REMOVING session from the WebServer-->session will be available throughout
	//session.removeAttribute("k");//once session removed we cant fetch it.
	//normally we use session to login in to the web page
	
//	int k=(int)session.getAttribute("k");
//	 k=k*k;
//	PrintWriter out=res.getWriter();
//	out.println("Result is="+k);
	
	int k=0;
	
	//As similar to session we can also use cookies
	
	//accepting the cookies-->cookie will be not one,it will be in the form of arrays
	javax.servlet.http.Cookie[] cookies=req.getCookies();
	//fetching the cookie that we need
	for(javax.servlet.http.Cookie c:cookies) {
		if(c.getName().equals("k"))
			k=Integer.parseInt(c.getValue());
		}
	k=k*k;
	PrintWriter out=res.getWriter();
	out.println("Result is"+k);
	System.out.println("sq called");
	
}
}
  