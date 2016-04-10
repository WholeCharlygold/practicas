<%-- 
   
--%>

<html>
    <head>
        <title>Saving Your Car</title>
  


        <meta charset="utf-8" />
      


		<meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <script type="text/javascript">

window.onunload = sale;
var valor;
if(document.cookie){
	galleta = unescape(document.cookie)
	galleta = galleta.split(';')
	for(m=0; m<galleta.length; m++){
		if(galleta[m].split('=')[0] == "recarga"){
			valor = galleta[m].split('=')[1]
			break;
		}
	}
	if(valor == "sip"){
		document.cookie = "recarga=nop"; 
		window.onunload = function(){};
		document.location.reload()
	}
	else{
	window.onunload=sale
	}
}
function sale(){
	document.cookie ="recarga=sip"
}
</script>
                      <%
                          
                          

String nom = (String)session.getAttribute("usu");
String compa = (String)session.getAttribute("nomb");
String correo=(String)session.getAttribute("correo");
if(nom==null){
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
"    text: \"Inicia sesion!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'index.html';\n" +
"});"); 
out.println("</script>"); 
}

%>

%>
   <body style="background-image:images/car.jpg ">
        <div>
            <header id="header">
					<h1 id="logo">Saving Your Car</h1>
					<nav id="nav">
						<ul>
							<li><a href="principal.jsp">Inicio</a></li>
							<li>
                                                            <a>Siniestro</a>
								<ul>
									<li><a href="registro1.html">Registrar</a></li>
                                                                        <li><a href="Aconsulta.jsp">Buscar</a></li>
								</ul>
							</li>
                                                        
                                                        <li>
                                                      
									<a>Codigo</a>
                                                                        <ul>
                                                                            <li> <a href="codigoalt.jsp">Alta</a> </li>
                                                                            <li> <a href="codigocon.jsp">Consulta</a>  </li>
                                                                        </ul>
                                                        </li>
							
							<li><a href="Aperfil.jsp">Perfil</a></li>
							<li>
                                                              <form method="post" action="cerrar">
                                                                
                                                           <input type="submit" value= "logout" >     
                                                            </form> </span></li>
                                                        <li><a href="quejas2.jsp">Queja o sugerencia</a></li>
						</ul>
					</nav>
				</header>
            <br><br><br>
            <form method="post" action="quejas2">
                <select name="tipo" selected="elija un tipo" required>
                    
   <option value="Sugerencia">Sugerencia</option>
   <option value="Queja">Queja</option>
  
   
</select> 
                <br>
                <br>
                <br>
                
                definicion del la situacion <input type="text" name="definicion" required > 
                <br>
                <br>
                <br>
                usuario <input type="text" name="correo" value="<%=correo%>" required readonly >
                
                
                <br>
                <br>
                <input type="submit" value="Enviar">
                
            </form>
            
            
            <br><br><br>
        </div>
    </body>
</html>
