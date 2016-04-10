<html>
    <head>
        <title>Saving Your Car</title>
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
        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <body style="background-image:images/car.jpg ">
        <div>
            <header id="header">
					<h1 id="logo">Saving Your Car</h1>
					<nav id="nav">
						<ul>
							<li><a href="Usuario.jsp">Inicio</a></li>
							<li>
								<a href="perfil.jsp">Perfil</a>
								
							</li>
							<li><a href="busqueda.html">Buscar</a></li>
							<li>
                                                          
                                                            <form method="post" action="cerrar">
                                                                
                                                           <input type="submit" value= "logout" >     
                                                            </form>    
                                                         
                                               
						</ul>
					</nav>
				</header>
            <br><br><br>
		
                    <div align="center"><h2>Información del usuario</h2></div>
                    
                    <%
String nom = (String)session.getAttribute("NombreEmpleado");
String compa= (String)session.getAttribute("compa");
String edad = (String)session.getAttribute("edad");
String sexo = (String)session.getAttribute("sexo");
String correo = (String)session.getAttribute("correo");
String telefono = (String)session.getAttribute("telefono");
String contra =(String)session.getAttribute("contra");
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

<br>
<br>
<center>
<table>
    <tr> 
        <td><font size="4"><b>Nombre</b></td>
        <td><%=nom%> </td></tr>
    <tr> 
        <td><font size="4"><b>Compañía</b></td>
        <td><%=compa%> </td></tr>
    <tr>
        <td><font size="4"><b>Edad</b></td>
        <td><%=edad%> </td></tr>
    <tr>
        <td><font size="4"><b>Sexo</b></td>
        <td><%=sexo%> </td></tr>
    <tr>
        <td><font size="4"><b>Correo</b></td>
        <td><%=correo%> </td></tr>

</table>
</center>
        <form method="post" action="perfilcam.jsp">
            
            <center>     <input type="submit" value="editar"> </center>
        </form>





                
        </div>
    </body>
</html>

