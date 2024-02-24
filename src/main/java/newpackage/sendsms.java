/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author heba
 */

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author W10 21H2 IOT
 */
public class sendsms {
       

  public Message sendmessage(String ACCOUNT_SID,String AUTH_TOKEN, String twilionum,String sendTo ,String sms)
  {

     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
      new com.twilio.type.PhoneNumber(sendTo),
      new com.twilio.type.PhoneNumber(twilionum),
      sms).create();
    waitForSMSCompletion(message.getSid());
   
    return  message;
  
  }
       private static void waitForSMSCompletion(String sSid) {
                     DataBase db=new DataBase();

            while (true) {
            // Fetch the message details
            Message message = Message.fetcher(sSid).fetch();

            // Get the status of the message
            Message.Status status = message.getStatus();

            // Print the SID and status of the message
            System.out.println("Message SID: " + message.getSid());
            System.out.println("Message Status: " + status);

            // If the message status is 'delivered', break the loop
            if (status == Message.Status.DELIVERED) {
                System.out.println("Message delivered!");
                
                try {
                    db.insertToDB(message.getSid(), message.getFrom().toString(), message.getTo(), message.getBody(), message.getDateUpdated().toString(),message.getStatus().toString());
                } catch (SQLException ex) {
                    Logger.getLogger(sendsms.class.getName()).log(Level.SEVERE, null, ex);
                }


                break;
            }

            // Sleep for a while before checking again
            try {
                Thread.sleep(5000); // Sleep for 5 seconds (adjust as needed)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       }}