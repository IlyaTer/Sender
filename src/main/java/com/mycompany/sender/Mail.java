
package com.mycompany.sender;

import java.util.*;
import java.io.PrintWriter;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Mail {
    
    private final String from = "java.servlet.dz@mail.ru";
    private Properties props;
    private final int port = 465;
    private final String login = "java.servlet.dz@mail.ru";
    private final String password = "qwerty1234567";
    private final String host = "smtp.mail.ru";
    
    private String to;
    private String subject;
    private String message;

    public Mail(String to, String subject, String message) {
        
        this.to = to;
        this.subject = subject;
        this.message = message;
                
        props = new Properties();
        
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        
        props.put("mail.smtp.ssl.enable", "true");
        props.put ("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
    }//end constructor
    
    
    public void send(PrintWriter pw){
        
        Session session = Session.getDefaultInstance(props, 
                 new Authenticator()
                 {
                     @Override
                     protected PasswordAuthentication 
                             getPasswordAuthentication()
                                {
                                    return new PasswordAuthentication(
                                    login,password);
                                }//end method
                 });//end anonim class
        
        try{
            
            Message msg = new MimeMessage(session);
             msg.setFrom(new InternetAddress(from));
             
             msg.setRecipient(Message.RecipientType.TO, 
                     new InternetAddress(to));
             msg.setSubject(subject);
             msg.setSentDate(new Date());

            
            msg.setText(message);

            // Отправка сообщения
            Transport.send(msg);
            pw.print("Message sent");
            pw.close();
        }
        catch(MessagingException e){
            pw.print("Message not sent");            
            pw.close();
            e.printStackTrace();           
        }
    }
    
    
    
    
    
    
    
    
}
