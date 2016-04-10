
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>

<%@page contentType="text/html" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;">
        <title>View File</title>
    </head>
    <body>
        
        <%  
           String id=(String)session.getAttribute("idsa");
            
            Blob file = null;
            byte[ ] fileData = null ;
Connection connectionBD = null;
        Statement sql = null;
   
            try
            {    
                Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","carlos98");
            sql = connectionBD.createStatement();
            ResultSet result3 = sql.executeQuery("select * from archivos where idarchivo ='"+id+"'") ;
          if(result3.next()){
                
                    file = result3.getBlob("fil");
                    fileData = file.getBytes(1,(int)file.length());
                
                } else 
                {
                    out.println("file not found!");
                    return;
                }
          
                
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "inline");
                response.setContentLength(fileData.length);
                
                OutputStream output = response.getOutputStream();
                output.write(fileData);
                
                output.flush();
                
            } catch (SQLException ex) {Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);} 
        %>
        
         </body>
</html>