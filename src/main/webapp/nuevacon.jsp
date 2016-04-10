<%-- 
    Document   : nuevacon
    Created on : 24/03/2016, 07:53:31 PM
    Author     : coro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main_1.css" />
        <script type="text/javascript">
        
            
            function makeid()
{
    var texto = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for( var i=0; i < 10; i++ )
        texto += possible.charAt(Math.floor(Math.random() * possible.length));
document.getElementById("Codigo").value = texto;


    return texto;
}
</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body style="background-image:images/car.jpg" onload="makeid()" >
        <div>
           <header id="header">
					<h1 id="logo">Saving Your Car</h1>
					<nav id="nav">
						<ul>
							<li><a href="index.html">Inicio</a></li>
							
						</ul>
					</nav>
				</header>
            <br>
        </div>
   <center>
       <h1>Recuperar contraseña</h1>
       <form method="post" action="recupera">
       <input type="text" name="Codigo" id="Codigo" value="" style="visibility:hidden" readonly>
       <br>
       
       Usuario <input type="text" name="usu" value="">
       <br>
       <input type="submit" value="enviar">
       
       </form>
       
   </center>
    </body>
</html>
