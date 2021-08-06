package com.tikakaran.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.tikakaran.entity.UserEntity;
import com.tikakaran.ofy.ObjectifyOfy.*;
import com.tikakaran.dao.DatastoreDao;
import com.tikakaran.dao.DatastoreDao.*;
import com.tikakaran.services.MailService;
import com.tikakaran.services.MailService.*;

public class SignupController extends HttpServlet
{
		
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
		{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			String cName=req.getParameter("cName");
			String fName=req.getParameter("fName");
			String mName=req.getParameter("mName");
			String Month=req.getParameter("Month");
			String Day=req.getParameter("Day");
			String Year=req.getParameter("Year");
			String mobile=req.getParameter("mobile");
			String emailid=req.getParameter("emailid");
			String uId=req.getParameter("uId");
			String pass=req.getParameter("password");
			String repass=req.getParameter("repassword");
			
			Iterator<UserEntity> li = DatastoreDao.checkIfUserAlreadyExist(uId).iterator();
			
			if(li.hasNext())
			{
				// user a;ready exist
				System.out.println("user already exist");
				res.sendRedirect("page-details.html");
			}
			
			else {
				
				UserEntity user=new UserEntity(cName,fName,mName,Month,Day,Year,mobile,emailid,uId,pass);
				
				DatastoreDao.saveUser(user);
				
				System.out.println("registration sucessfull");
				MailService.mailService();
				
				res.sendRedirect("login.html");
			}
			/*if(DatastoreDao.saveData(cName,fName,mName,DOB,mobile,uId,pass,repass)==true)
			{
				System.out.println("Registration is SUCCESSFUL!!");
				res.sendRedirect("/login.html");
				//sentMail(name,uId,pass);
			}
			
			else if(DatastoreDao.saveData(cName,fName,mName,DOB,mobile,uId,pass,repass)==false)
			{
				System.out.println("Registration is NOT Successful!!!");
				res.sendRedirect("/page-details.html");
				//sentMail(name,uId,pass);
			}
			
			/*else
			{	
				System.out.println("Registration is NOT Successful!!!");
			}*/
			
		    ///}
		}
	
	/*public static boolean check(String uId,String pass,List<UserEntity> det)
	{
		Iterator<UserEntity> i=det.iterator(); 
//		System.out.println("iteration...");
		
		while(i.hasNext())
		{
			
			
			UserEntity ud=i.next();
			
		if((ud.getuserID()==uId) && (ud.getPass()==pass))
				{
					//System.out.println("565656");
					return false;
				}
			else 
				{
				   //System.out.println("8989898");
					return true;
				}
			
		 }
			return false;
		
	  }*/

		
}
