/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Alumno
 */
public class coda extends HttpServlet {


    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

       
        java.util.Date date=new java.util.Date();
         
        Timestamp now = new Timestamp(date.getTime());
        String compa = request.getParameter("Compania");
    
        
       String cod = request.getParameter("Codigo");
       String correo=request.getParameter("correo");
       String correo2=request.getParameter("correo2"); 
      String pass=request.getParameter("pass");
        boolean a,b,c,d,e;
        a=cod!=null && !cod.isEmpty();
        b=correo!=null && !correo.isEmpty();
        c=correo2!=null && !correo2.isEmpty();
        d=pass!=null && !pass.isEmpty();
        e=compa!=null && !compa.isEmpty();
       
        try (PrintWriter out = response.getWriter()) {
            
            if(a&&b&&c&&d&&e){
            
            
           
        Connection connectionBD = null;
        Statement sql ;

        
        
        
        
        Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
              out.println(cod);
                out.println(compa);
                  out.println(now);
            int resu=  sql.executeUpdate("insert into Codigo values('"+cod+"','"+compa+"','"+now+"')");
          if(resu==1){
              
              
      

   final String miCorreo = correo2; //correo del administrador desde que seran enviados los mensajes
    final String miContraseña = pass; //contraseña del correo
 
    String servidorSMTP = "smtp.gmail.com";
   String puertoEnvio = "25";
    String mailReceptor = correo;
    String asunto = "codigo"; 
    String cuerpo = "Hola empleado de la compañia " + compa +"\n"+
                     "Para que puedas registrarte necesitaras un codigo de verificación, el cual es: "+ cod + "\n"+
                      "espero puedas registarte, hasta luego"; //mensaje que sera enviado en el correro
  
               Properties props = new Properties();
        props.put("mail.smtp.user", miCorreo);
        props.put("mail.smtp.host", servidorSMTP);
        props.put("mail.smtp.port", puertoEnvio);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", puertoEnvio);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

     
        //SecurityManager security = System.getSecurityManager();

        try {
           // Authenticator auth = new autentificadorSMTP();
            
            
            
            Session session;
       session = Session.getInstance(props, 
               new javax.mail.Authenticator() {
                   
                   
                   
                   
                   @Override
                   protected PasswordAuthentication getPasswordAuthentication()  {
                       
                       
                       
                       return new PasswordAuthentication(miCorreo,miContraseña);
                       
                       
                       
                   }
                   
               });

 

            session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);
            msg.setText(cuerpo);
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(miCorreo));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    mailReceptor));
            Transport.send(msg);
            
        } catch (Exception mex) {
        }
    
    
    
             
               response.sendRedirect("http://localhost:8080/SYC/principal.jsp");
          }
            
        
          else{
              out.println("<script type=\"text/javascript\">");  
out.println("alert('el siniestro tecleado no existe');");
  out.println("document.location=('http://localhost:8080/SYC/codigoalt.jsp')");
out.println("</script>");
              
          }
            }
            else{
                 response.setContentType("text/html");  
               out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
                out.println("<script src=\"dist/sweetalert.min.js\"></script> <link rel=\"stylesheet\" type=\"text/css\" href=\"dist/sweetalert.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<br>");
                out.println("<script type=\"text/javascript\">");  
                out.println("sweetAlert({\n" +
"    title: \"Error!\",\n" +
"    text: \"Llene todos los campos!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'codigoalt.jsp';\n" +
"});"); 
out.println("</script>"); 
            }
        }
    }
    
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(coda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(coda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(coda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
