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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author coro
 */
public class camperu extends HttpServlet {

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
   
        
        
              
            
 
         String nom = request.getParameter("nome");
          String edad = request.getParameter("edad");
          
            String correo = request.getParameter("correo");
             String telefono = request.getParameter("tel");
               String contr = request.getParameter("con");
               String tipo = (String) request.getSession().getAttribute("tipo");
               boolean a,b,c,d,z;
               a=nom!=null&&!nom.isEmpty();
               b=edad!=null&&!edad.isEmpty();
               c=correo!=null&&!correo.isEmpty();
               d=telefono!=null&&!telefono.isEmpty();
               z=contr!=null&&!contr.isEmpty();
               
               
               
                try (PrintWriter out = response.getWriter()) {
                    if(a&&b&&c&&d&&z){
                        
                     Connection connectionBD = null;
        Statement sql ;
                        Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            ResultSet result3 = sql.executeQuery("select * from usuario where correo ='"+correo+"'") ;
          if(result3.next()){
              
              
          
                    
                    
               
               int edad2=Integer.parseInt(edad);
               int telefono2=Integer.parseInt(telefono);
               
             String contr2 = ""; 

 @SuppressWarnings("UnusedAssignment")

 MessageDigest md = null; 

 try { 

 md = MessageDigest.getInstance("SHA-1"); 

 BigInteger hash = new BigInteger(1, md.digest(contr.getBytes())); 

 contr2 = hash.toString(16); 

 } catch (NoSuchAlgorithmException e) { 

 e.printStackTrace(); 

 }   
 
   
  
          
    
       
                                                     // "UPDATE mitabla SET "+ "NOMBRE='"+ nombre+ "', EDAD="+ edad+" WHERE clave=" + clave+";";
        
    
            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            out.println("hola");
            
            int resu=  sql.executeUpdate("UPDATE Usuario SET "+"NombreEmpleado='"+nom+"',edad='"+edad2+"',telefono='"+telefono2+"',contraseña='"+contr2+"' WHERE correo='"+correo+"';");
          if(resu==1){
              if(tipo.equals("administrador")){
              response.sendRedirect("http://localhost:8080/SYC/index.html");
               }
              else{
                  
                   response.sendRedirect("http://localhost:8080/SYC/Usuario.jsp");
              }
            
            
            
    }
    }else
          {
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
"    text: \"No le quiera jugar al verga, compa!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'perfilcam.jsp';\n" +
"});"); 
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
"    window.location.href = 'perfilcam.jsp';\n" +
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
            Logger.getLogger(camper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(camper.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(camper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(camper.class.getName()).log(Level.SEVERE, null, ex);
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
