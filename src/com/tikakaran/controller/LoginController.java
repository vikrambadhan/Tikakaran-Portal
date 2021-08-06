package com.tikakaran.controller;

import static com.tikakaran.ofy.ObjectifyOfy.ofy;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.appengine.api.search.query.ExpressionParser.index_return;
import com.tikakaran.entity.UserEntity;
import com.tikakaran.entity.UserEntity.*;
import com.tikakaran.dao.DatastoreDao;
import com.tikakaran.dao.DatastoreDao.*;
import com.tikakaran.ofy.ObjectifyOfy.*;



//import com.tikakaran.entity.UserEntity;

public class LoginController extends HttpServlet
{
		public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
		{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			String cName= req.getParameter("cName");
			String fName= req.getParameter("fName");
			String mName= req.getParameter("mName");
			String Month= req.getParameter("Month");
			String Day= req.getParameter("Day");
			String Year= req.getParameter("Year");
			String mobile= req.getParameter("mobile");
			String emailid=req.getParameter("emailid");
			String uId=req.getParameter("uId");
			//String name=req.getParameter("name");
			String password=req.getParameter("password");
			UserEntity udi = new UserEntity(cName, fName, mName, Month, Day, Year, mobile,emailid, uId, password);
			ofy().save().entity(udi);
			
			List<UserEntity>det=ofy().load().type(UserEntity.class).list();
			
			//List<UserEntity> det=DatastoreDao.load(uId,pass);
			Iterator<UserEntity> li=DatastoreDao.checkIfUserAlreadyExist(uId).iterator();
			Iterator<UserEntity> l=DatastoreDao.checkIfUserAlreadyExistbyLogin(password).iterator();
			
			
			
			while(li.hasNext())
			{
				System.out.println("do  login");
				UserEntity ud=li.next();
				String uID = ud.getuId();
				String passw = ud.getPassword();
				//int int1= Integer.parseInt(uID);
				//int int2= Integer.parseInt(uId);
				//int int3= Integer.parseInt(password);
				//int int4= Integer.parseInt(passw);
				if(uID.equals(uId) && (passw.equals(password)))
				{
					out.println("login sucessful");
					res.sendRedirect("schedulertable.html");
				}
				else
					{System.out.println("not matching");
				res.sendRedirect("login.html");}
			}
			/*else
			{
				UserEntity ud= li.next();
				String userID=ud.getuserID();
				String passw = ud.getPass();
				if((userID==uId)&& (passw==pass))
				{
				System.out.println("login not sucessful");
				res.sendRedirect("schedulertable.html");
				}
				else
					System.out.println("Sory");
			}*/
			
			
			/*if(	check(uId,pass,det))
			{	
				System.out.println("login sucessful");
				res.sendRedirect("/index.html");
			}
			else
			{
				
			}
			/*List<UserDetails>det=ofy().load().type(UserDetails.class).filter("name", name).list();
			out.println(det);
			//new LoginService().isValid(ud);
			
			//out.println("<html><body>Checking Username and Password....");
			/*if(name.equals("Ashish")&&pass.equals("Password"))
			{
				out.println("in serice:User is valid! ");
			
			}
			else
				out.println("in service:User is not valid! ");
			
			out.println("</body></html>");*/
		}
		


/*public boolean check(String uId,String pass,List<UserEntity> det)
{
	Iterator<UserEntity> i=det.iterator(); 
//	System.out.println("iteration...");
	
	while(i.hasNext())
	{
		System.out.println("in while loop");
		
		UserEntity ud=i.next();
		
	if((ud.getuserID()==uId) && (ud.getPass()==pass))
			{
				System.out.println("565656");
				return true;
			}
		else 
			{
			System.out.println("8989898");
				return false;
			}
		
	 }
		return false;
	
  }*/
}