/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 
 */
/*@WebServlet(urlPatterns = {"/ConsultaServlet"})*/
public class consulta extends HttpServlet {

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
        HttpSession sesion = request.getSession();
   String compa="";
        compa = (String)sesion.getAttribute("usu");
        String ide = request.getParameter("ide");
    String hola=null;
           
       
        Connection connectionBD = null;
        Statement sql = null;
   
        
        try (PrintWriter out = response.getWriter()) {
            
            
          if(compa == null){
              
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
"    text: \"Inicia sesion para buscar!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'index.html';\n" +
"});"); 
out.println("</script>"); 
          
        }
          
     
          else{
              if (ide!=null && !ide.isEmpty()){
              
              Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            ResultSet result3 = sql.executeQuery("select * from archivos where Idsiniestro ='"+ide+"'") ;
          if(result3.next()){
              
              
              String idar=request.getParameter("idar");
                      String nomar=request.getParameter("nombre");
                      
                           
            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            ResultSet result = sql.executeQuery("select * from Siniestro where IdSiniestro ='"+ide+"'") ;
            
            
            if(result.next()){
          String IdSiniestro =  result.getString("IdSiniestro");
            String Compania =  result.getString("Compania");
            String correoU =  result.getString("correoU");
            String IdVehiculo =  result.getString("IdVehiculo");
            String asegurado =  result.getString("asegurado");
            String poliza =  result.getString("poliza");
            String VigenciaPoliza =  result.getString("VigenciaPoliza");
            String fechasiniestro =  result.getString("fechaSiniestro");
            String fechaAperturaCaso =  result.getString("fechaAperturaCaso");
            String fechaClausuraCaso =  result.getString("fechaClausuraCaso");
            String Informe =  result.getString("Informe");
        
 

        request.getSession().setAttribute("IdSiniestro", IdSiniestro+ ""); 
        request.getSession().setAttribute("Compania", Compania+ ""); 
        request.getSession().setAttribute("correoU",correoU+ ""); 
        request.getSession().setAttribute("IdVehiculo",IdVehiculo+ ""); 
        request.getSession().setAttribute("asegurado",asegurado+ ""); 
        request.getSession().setAttribute("poliza",poliza+ "");
         request.getSession().setAttribute("VigenciaPoliza",VigenciaPoliza+ "");
          request.getSession().setAttribute("fechaSiniestro", fechasiniestro+ "");
           request.getSession().setAttribute("fechaAperturaCaso",fechaAperturaCaso+ "");
                  request.getSession().setAttribute("fechaClausuraCaso", fechaClausuraCaso+ "");
                            request.getSession().setAttribute("Informe", Informe+ "");
                            
                            
         Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            ResultSet result2 = sql.executeQuery("select * from Vehiculo where IdVehiculo ='"+IdVehiculo+"'");
            
            
            while(result2.next()){
           String idV = result2.getString("IdVehiculo");
           String NombreV = result2.getString("NombreVehiculo");
           String marca= result2.getString("marca");
           String modelo=result2.getString("modelo");
         
           String placas= result2.getString("placas");
           String numS =  result2.getString("numeroSerie");
           String numM =  result2.getString("numeroMotor");
           String costo =  result2.getString("costo");
           
           request.getSession().setAttribute("idV", idV+ ""); 
        request.getSession().setAttribute("NombreV", NombreV+ ""); 
        request.getSession().setAttribute("marca",marca+ ""); 
        request.getSession().setAttribute("modelo",modelo+ ""); 
        
         request.getSession().setAttribute("placas",placas+ ""); 
          request.getSession().setAttribute("numS",numS+ "");
           request.getSession().setAttribute("numM",numM+ ""); 
     
        request.getSession().setAttribute("costo",costo+ "");
        
        

        response.sendRedirect("http://localhost:8080/SYC/respuesta2.jsp");
            }
 
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
"    text: \"Siniestro no encontrado!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'Aconsulta.jsp';\n" +
"});"); 
out.println("</script>"); 
                }
              }
          else
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
"    text: \"Llene todos los campos!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'Aconsulta.jsp';\n" +
"});"); 
out.println("</script>"); 
                  
                  }
        }
    }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(sservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(sservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}