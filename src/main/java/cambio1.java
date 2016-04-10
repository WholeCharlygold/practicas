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
import java.sql.ResultSet;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author coro
 */
public class cambio1 extends HttpServlet {

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
   String nomVehi = request.getParameter("nombreVehiculo");
               String mar = request.getParameter("marca");
                String mod= ((String)request.getParameter("modelo"));
                    String plac = request.getParameter("placas");
                    String nose = request.getParameter("numeroSerie");
                    String nomo = request.getParameter("numeroMotor");
                    String cos = request.getParameter("costo");
                  String correo2 =request.getParameter("correo2");
            String pass =request.getParameter("pass");
               int cos2=Integer.parseInt(cos);
            
        String idSin = request.getParameter("idSiniestro");
         String compania = request.getParameter("compania");
         String correo = request.getParameter("correoU");
          String asegurado = request.getParameter("asegurado");
           String poliza = request.getParameter("poliza");
           String vipoliza1 = request.getParameter("vipoliza");
            String fesi1 = request.getParameter("fesi");
            String feap1 = request.getParameter("feap");
            String feclau1 = request.getParameter("feclau");
            String info = request.getParameter("info");
            
             String idVehi = request.getParameter("idVehiculo");
            
               int idVehi2=Integer.parseInt(idVehi);
              
               int idsin2=Integer.parseInt(idSin);
               
               

    
        Connection connectionBD = null;
        Statement sql ;
   
       // "UPDATE mitabla SET "+ "NOMBRE='"+ nombre+ "', EDAD="+ edad+" WHERE clave=" + clave+";";

   try (PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            int resu=  sql.executeUpdate("UPDATE Vehiculo SET "+"NombreVehiculo='"+nomVehi+"',marca='"+mar+"',modelo='"+mod+"',placas='"+plac+"',numeroSerie='"+nose+"',numeroMotor='"+nomo+"',costo='"+cos2+"'WHERE IdVehiculo="+idVehi2+";");
           out.println("hola");
          if(resu==1){
              Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
           int resu2=sql.executeUpdate("UPDATE  Siniestro SET "+"asegurado='"+asegurado+"',poliza='"+poliza+"',vigenciaPoliza='"+vipoliza1+"',fechaSiniestro='"+fesi1+"',fechaAperturaCaso='"+feap1+"',fechaClausuraCaso='"+feclau1+"',Informe='"+info+"'WHERE IdSiniestro="+idsin2+";");
           if (resu2==1)
               {
               
     final String miCorreo = correo2; //correo del administrador desde que seran enviados los mensajes
    final String miContraseña = pass; //contraseña del correo
 
    String servidorSMTP = "smtp.gmail.com";
   String puertoEnvio = "25";
    String mailReceptor = correo;
    String asunto = "codigo"; 
    String cuerpo = "Hola empleado de la compañia " + compania +"\n"+
                     "Se ha actualizado el siniestro del id "+idSin + "\n"+
                      "Porfavor Consultelo hasta luego"; //mensaje que sera enviado en el correro
  
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

     
   

        try {
          
            
            
            
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
            }
          else
          {
              
            
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
            Logger.getLogger(cambio1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cambio1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cambio1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cambio1.class.getName()).log(Level.SEVERE, null, ex);
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
