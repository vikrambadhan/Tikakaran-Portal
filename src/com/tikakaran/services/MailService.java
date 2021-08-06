package com.tikakaran.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.Message.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;

import java.io.*;

import javax.servlet.http.*;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import java.util.*;







public class MailService extends HttpServlet
{
   public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
   {
       res.setContentType("text/html");
       PrintWriter out = res.getWriter();
      /* String dob = "08/07/16";
    	  //SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
       
       
       //String dateStart = "11/03/14 09:29:58";
       //String dateStop = "11/03/14 09:33:43";

       //Custom date format
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy ");
       Date cdate = new Date();
       out.println(format.format(cdate));
       String c= (String)format.format(cdate);
       Date d1 = null;
       Date d2 = null;
       try {
           d1 = format.parse(dob);
           d2 = format.parse(c);
       } catch (Exception e) {
           e.printStackTrace();
       }
       long diff = d2.getTime() - d1.getTime();
       long diffSeconds = diff / 1000 % 60;
       long diffMinutes = diff / (60 * 1000) % 60;
       long diffHours = diff / (60 * 60 * 1000);
       int diffInDays = (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

       System.out.println("Time in seconds: " + diffSeconds + " seconds.");
       System.out.println("Time in minutes: " + diffMinutes + " minutes.");
       System.out.println("Time in hours: " + diffHours + " hours.");
       System.out.println("Time in days: " + diffInDays + " days.");
       
       
       LocalDate today = LocalDate.now();
       LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

       Period p = Period.between(birthday, today);
       long p2 = ChronoUnit.DAYS.between(birthday, today);
       System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                          " months, and " + p.getDays() +
                          " days old. (" + p2 + " days total)");
       
       */
       
       DateTime datetym =new DateTime();
       System.out.println("DateTime = " +datetym);
       
       /*DateTime dt = new DateTime(2016,07,10, 0,0,0); 
       out.println("\nDate of Birth = " +dt);
       Period p= new Period(dt,datetym);
       long days= p.getDays();
       DateTime t = new DateTime(days);
       out.println("\nDifference :" +t);
       */
       System.out.println("\nMinus"+datetym.minusYears(2017).minusMonths(07).minusDays(10));
       
       
       
       mailService();
       
       
   }    
   
   
   
       public static void  mailService()
       { 
       Properties pr = new Properties();
       
	Session session = Session.getDefaultInstance(pr,null);
       String msgBody = "Hello"
       
       + ".\nyou are sucessfully register on the houseof change.\n\nthe details given are:\n\nemail:"
       + "shivam"  ;
       Message msg = new MimeMessage(session);
       try {
    	   msg.setFrom(new InternetAddress("lshivam4@gmail.com","shivam"));
    	   msg.addRecipient(Message.RecipientType.TO, new InternetAddress("kamalikasaha.cse.msit@gmail.com","kam" ));
    	   msg.setSubject("Registeration Successful ");
           msg.setText(msgBody);
           Transport.send(msg);
           
       }
      
       
      catch(Exception e)
      {
	      e.printStackTrace();    
      }
    } 
   
}