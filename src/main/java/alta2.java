/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.*;
import org.apache.commons.io.*;





/**
 *
 * @author Alumno
 */
public class alta2 extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
   

    
        
        
        try (PrintWriter out = response.getWriter()) {
        
        
      String nomVehi = request.getParameter("nombreVehiculo");
               String mar = request.getParameter("marca");
                String mod= ((String)request.getParameter("modelo"));
                    String plac = request.getParameter("placas");
                    String nose = request.getParameter("numeroSerie");
                    String nomo = request.getParameter("numeroMotor");
                    String cos = request.getParameter("costo");
            String correo2 =request.getParameter("correo2");
            String pass =request.getParameter("pass");
               
      
        String idSin = request.getParameter("idSiniestro");
         String compania = request.getParameter("compania");
         String correo = request.getParameter("correoU");
          String asegurado = request.getParameter("asegurado");
           String poliza = request.getParameter("poliza");
           String vipoliza = request.getParameter("vipoliza");
          
           String fesi = request.getParameter("fesi");
          
           
           String feap = request.getParameter("feap");
           
           
           String feclau = request.getParameter("feclau");
          
           
           String info = request.getParameter("info");
            
             String idVehi = request.getParameter("idVehiculo");
            String idar=request.getParameter("idar");
            String nomar=request.getParameter("nombrear");
              
              InputStream inputStream = null;
               
            Part filePart = request.getPart("wor");
            boolean a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v;
            
            a=nomVehi!=null && !nomVehi.isEmpty();
            b=mar!=null && !mar.isEmpty();
            c=mod!=null && !mod.isEmpty();
            d=plac!=null && !plac.isEmpty();
            e=nose!=null && !nose.isEmpty();
            f=nomo!=null && !nomo.isEmpty();
            g=cos!=null && !cos.isEmpty();
            h=correo2!=null && !correo2.isEmpty();
            i=pass!=null && !pass.isEmpty();
            j=idSin!=null && !idSin.isEmpty();
            k=compania!=null && !compania.isEmpty();
            l=correo!=null && !correo.isEmpty();
            m=asegurado!=null && !asegurado.isEmpty();
            n=poliza!=null && !poliza.isEmpty();
            o=vipoliza!=null && !vipoliza.isEmpty();
            p=fesi!=null && !fesi.isEmpty();
            q=feap!=null && !feap.isEmpty();
            r=feclau!=null && !feclau.isEmpty();
            s=info!=null && !info.isEmpty();
            t=idVehi!=null && !idVehi.isEmpty();
            u=idar!=null && !idar.isEmpty();
            v=nomar!=null && !nomar.isEmpty();
            
            
            
            if (filePart != null) 
                {
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    inputStream = filePart.getInputStream();
                }
           if(a && b && c && d && e && f && g && h && i && j && k && l && m && n && o && p && q && r && s && t ){
    
                
               
            
            
            
               int cos2=Integer.parseInt(cos);
                int idVehi2=Integer.parseInt(idVehi);
                int idsin2=Integer.parseInt(idSin);

    
        Connection connectionBD = null;
        Statement sql ;
   
        
   
//           out.println(idsin2);
//             out.println(compania);
//             out.println(correo);
//             out.println(idVehi2);
//             out.println(asegurado);
//             out.println(poliza);
//             out.println(vipoliza1);
//             out.println(vipoliza2);
//             out.println(vipoliza3);
//             out.println(fesi1);
//             out.println(fesi2);
//             out.println(fesi3);
//             out.println(feap1);
//             out.println(feap2);
//             out.println(feap3);
//             out.println(feclau1);
//             out.println(feclau2);
//             out.println(feclau3);
//             out.println(info);
            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            int resu=  sql.executeUpdate("insert into Vehiculo values('"+idVehi2+"','"+nomVehi+"','"+mar+"','"+mod+"','"+plac+"','"+nose+"','"+nomo+"','"+cos2+"')");
           out.println("hola");
          if(resu==1){
              Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
           int resu2=sql.executeUpdate("insert into siniestro values('"+idsin2+"','"+compania+"','"+correo+"','"+idVehi2+"','"+asegurado+"','"+poliza+"','"+vipoliza+"','"+fesi+"','"+feap+"','"+feclau+"','"+info+"')");
           if (resu2==1) {
               
          
              // Class.forName("com.mysql.jdbc.Driver");
            //connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            //sql = connectionBD.createStatement();
           //int resu3=sql.executeUpdate("insert into archivos values('"+idar+"','"+nomar+"','"+inputStream+"','"+idsin2+"')");
           
            //llenado de la fecha
             PreparedStatement pstatement1=null;
            //variable para la conexion
            Connection conn1=null;
           
            conn1= DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
           
            pstatement1=conn1.prepareStatement("insert into archivos values(?,?,?)");
           
            pstatement1.setInt(1, idsin2);
           
            pstatement1.setBinaryStream(2, inputStream, (int) filePart.getSize());
            
            pstatement1.setInt(3, idsin2);
            
           
            pstatement1.executeUpdate();
           
           
           
           
           
           
           
               
               
    final String miCorreo = correo2; //correo del administrador desde que seran enviados los mensajes
    final String miContraseña = pass; //contraseña del correo
    final String servidorSMTP = "smtp.gmail.com";
    final String puertoEnvio = "25";
    String mailReceptor = correo;
    String asunto = "codigo"; 
    String cuerpo = "Hola empleado de la compañia " + compania +"\n"+
                     "Se te ha registrado un siniestro con el id "+ idSin + "\n"+
                      "Porfavor Consultelo Hasta luego"; //mensaje que sera enviado en el correro
  
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
            mex.printStackTrace();
        }
               
               
               
                response.sendRedirect("http://localhost:8080/SYC/principal.jsp");}
            }
          else
          {
              
            
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
"    window.location.href = 'registro1.html';\n" +
"});"); 
out.println("</script>"); 
            }
                
        }
       
        {
                
                
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
            Logger.getLogger(alta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(alta.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(alta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(alta.class.getName()).log(Level.SEVERE, null, ex);
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
    

