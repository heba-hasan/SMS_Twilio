/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import com.twilio.rest.api.v2010.account.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author heba
 */
public class NewServlet extends HttpServlet {

  sendsms sms=new sendsms();
  DataBase db=new DataBase();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      try {
          PrintWriter pen=response.getWriter();
          String [] cred=db.getcred();
          
          String reciever_number=request.getParameter("to");
          String smstext=request.getParameter("sms");
   //        Message message=  
 Message message=sms.sendmessage(cred[1], cred[0],cred[2],reciever_number,smstext);
         System.out.println("ss= "+sendsms.Status);
if (sendsms.Status=="delivered")
{
response.sendRedirect("smssucess.html");
}
else 
{
response.sendRedirect("smsfailed.html");

}
  // System.out.println("sttts "+res.getString("msg_status"));
  // request.setAttribute("messagestatus", message.getStatus());
//   if(db.getmessages().getString("msg_status")=="delieverd")
//   {
//   
//   }
//           pen.println(message.getBody());
      } catch (SQLException ex) {
         response.sendRedirect("smsfailed.html");
      }


  

    }

    
}
