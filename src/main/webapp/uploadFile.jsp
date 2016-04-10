
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem" %> 
 <%@page import="java.util.*" %> 
 <%@page import="org.apache.commons.fileupload.*" %> 

 <%@page import="org.apache.commons.io.*" %> 
 <%@page import="java.io.*" %> 


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
 
String destination = "images/";


        String destinationRealPath = application.getRealPath( destination );


       


        DiskFileItemFactory factory = new DiskFileItemFactory();


      factory.setSizeThreshold( 1024 );


        


       factory.setRepository( new File( destinationRealPath ) );


       


        ServletFileUpload uploader = new ServletFileUpload( factory );


        


        try


        {


               List items = uploader.parseRequest( request );


               Iterator iterator = items.iterator();


               


               while( iterator.hasNext() )


               {


                        FileItem item = (FileItem) iterator.next();


                        File file = new File( destinationRealPath, item.getName() );


                       item.write( file );


                      out.write( "<p>" + file.getName() + " was uploaded successfully</p>" ) ;


               }


       }


        catch( FileUploadException e )


        {


               out.write( "<p>FileUploadException was thrown..." + e.getMessage() + "</p>" );


      }

 %> 
    </body>
</html>
