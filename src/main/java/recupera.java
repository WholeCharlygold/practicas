/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
public class recupera extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String pass=request.getParameter("Codigo");
        String usu=request.getParameter("usu");
         String contr2 = ""; 

 @SuppressWarnings("UnusedAssignment")

 MessageDigest md = null; 

 try { 

 md = MessageDigest.getInstance("SHA-1"); 

 BigInteger hash = new BigInteger(1, md.digest(pass.getBytes())); 

 contr2 = hash.toString(16); 

 } catch (NoSuchAlgorithmException e) { 

 e.printStackTrace(); 

 }    Connection connectionBD = null;
        Statement sql ;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        
        Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            
            //int resu=  sql.executeUpdate("UPDATE Usuario SET "+"contraseña='"+pass+"'WHERE correo="+usu+";");
 int resu=  sql.executeUpdate("UPDATE Usuario SET "+"contraseña='"+contr2+"' WHERE correo='"+usu+"';");            //int resu=  sql.executeUpdate("UPDATE Vehiculo SET "+"NombreVehiculo='"+nomVehi+"',costo='"+cos2+"'WHERE IdVehiculo="+idVehi2+";");
          
          if(resu==1){
            final String miCorreo = "wedart148@gmail.com"; //correo del administrador desde que seran enviados los mensajes
    final String miContraseña = "secretajuanito"; //contraseña del correo
 
    String servidorSMTP = "smtp.gmail.com";
   String puertoEnvio = "25";
    String mailReceptor = usu;
    String asunto = "codigo"; 
    String cuerpo = "Esta es tu nueva contraseña:"+pass+"   te recomendamos cambiar lo mas pronto posible tu contraseña"; //mensaje que sera enviado en el correro
  
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
    
    
    
             
               response.sendRedirect("http://localhost:8080/SYC/index.html");
          
          
            
            
            
            
            
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
"    text: \"Usuario no encontrado!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'nuevacon.jsp';\n" +
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(recupera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(recupera.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(recupera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(recupera.class.getName()).log(Level.SEVERE, null, ex);
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
