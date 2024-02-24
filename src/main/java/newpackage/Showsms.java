/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author heba
 */
public class Showsms extends HttpServlet {


    DataBase db=new DataBase();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter pen=response.getWriter();
        
       ResultSet res= db.getmessages();
       
           try {
                  pen.println("<html>\n" +
"    <head>   <link rel=\"stylesheet\" href=\"newcss.css\"></head>\n" +
"    <body>\n" +
"        <h1>All SMSs</h1>\n" +
"        <table class=\"list\">\n" +
"            <thead class=\"list\">\n" +
"                <tr  class=\"list\">\n" +
"                    <td class=\"list top\">ID</td>\n" +
"                    <td class=\"list top\">From</td>\n" +
"                    <td class=\"list top\">To</td>\n" +
"                    <td class=\"list top\">Body</td>\n" +
 "                    <td class=\"list top\">Time</td>\n" +
"                    <td class=\"list top\">Status</td>\n" +

"                </tr>\n" +
"            </thead>\n" +
"            <tbody class=\"list\">");

while (res.next()) {
    pen.println("<tr class=\"list\">\n" +
                 "    <td class=\"list id\">" + res.getString("msg_id") + "</td>\n" +
                 "    <td class=\"list\">" + res.getString("sender_number") + "</td>\n" +
                 "    <td class=\"list\">" + res.getString("reciever_number") + "</td>\n" +
                 "    <td class=\"list\">" + res.getString("msg_body") + "</td>\n" +
 "    <td class=\"list\">" + res.getString("msg_time") + "</td>\n" +
 "    <td class=\"list status\">" + res.getString("msg_status")
         +
 "</tr>\n");
}

pen.println("        <script src=\"newjavascript.js\"></script>\n" +
"</tbody></table></body></html>");

           
           } catch (SQLException ex) {
ex.printStackTrace();           }
     
               }
    }

   

