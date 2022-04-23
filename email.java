/*Applicazione che consente di inviare email tramite java, provider (Gmail). (mail.jar) (contiene tutte le classi javax.mail)
activation.jar
Si deve installaere un webService per il funzionamento, le librerie usate sono gia presenti all'interno (es: Wildfly, TomEE, JBoss, ecc)*/

package it.francesco.email;
 
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EmailSender {
 private String from = "test@gmail.com";
 private String username = "eemail@gmail.com";
 private String password = "tua password";
 
 public static void main(String[] args) throws AddressException, MessagingException {
   EmailSender es = new EmailSender();
   es.sendEmail(
     "email@gmail.com",
     "Test email",
     "messaggio......... \n\n\n ciaooo!");
 }
 
 public void sendEmail(String to, String subject, String text) throws AddressException, MessagingException {
   /* oggetto di tipo Properties che conterrà i parametri di configurazione per la connessione al mail server */
   Properties props = new Properties();
   props.put("mail.smtp.auth", "true");
   props.put("mail.smtp.starttls.enable", "true");
   props.put("mail.smtp.host", "smtp.gmail.com");
   props.put("mail.smtp.port", "587");
 
  /* Creiamo una connessione al mail server */
  Session session = Session.getInstance(
     props,
     new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(username, password);
       }
    });
 
  /* creiamo il messaggio impostando i destinatari, l'oggetto e il contenuto del messaggio */
  Message message = new MimeMessage(session);
  message.setFrom(new InternetAddress(from));
  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
  message.setSubject(subject);
  message.setText(text);
 
  /* Invio email */
  Transport.send(message);
 }
}
