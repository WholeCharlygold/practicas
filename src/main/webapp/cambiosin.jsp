
<html>
    <head>
        <title>Saving Your Car</title>
        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main_1.css" />
                <link rel="stylesheet" href="dist/sweetalert.css" type="text/css">
                <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>

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
$(function() {
    $( "#vipoliza" ).datepicker({ 
    dateFormat: "mm/dd/yy",
    defaultDate: "01/01/2016",
    minDate: "01/01/1925",
    maxDate: "12/31/2020",
    changeMonth: true,
    changeYear: true,
    yearRange: "1925:2020",
    onClose: function(dateText, inst) {
        var validDate = $.datepicker.formatDate( "mm/dd/yy", $('#vipoliza').datepicker('getDate'));
            $('#vipoliza').datepicker('setDate', validDate);
        }
    });
});
$(function() {
    $( "#fesi" ).datepicker({ 
    dateFormat: "mm/dd/yy",
    defaultDate: "01/01/2016",
    minDate: "01/01/1925",
    maxDate: "12/31/2020",
    changeMonth: true,
    changeYear: true,
    yearRange: "1925:2020",
    onClose: function(dateText, inst) {
        var validDate = $.datepicker.formatDate( "mm/dd/yy", $('#fesi').datepicker('getDate'));
            $('#fesi').datepicker('setDate', validDate);
        }
    });
});
$(function() {
    $( "#feap" ).datepicker({ 
    dateFormat: "mm/dd/yy",
    defaultDate: "01/01/2016",
    minDate: "01/01/1925",
    maxDate: "12/31/2020",
    changeMonth: true,
    changeYear: true,
    yearRange: "1925:2020",
    onClose: function(dateText, inst) {
        var validDate = $.datepicker.formatDate( "mm/dd/yy", $('#feap').datepicker('getDate'));
            $('#feap').datepicker('setDate', validDate);
        }
    });
});
$(function() {
    $( "#feclau" ).datepicker({ 
    dateFormat: "mm/dd/yy",
    defaultDate: "01/01/2016",
    minDate: "01/01/1925",
    maxDate: "12/31/2020",
    changeMonth: true,
    changeYear: true,
    yearRange: "1925:2020",
    onClose: function(dateText, inst) {
        var validDate = $.datepicker.formatDate( "mm/dd/yy", $('#feclau').datepicker('getDate'));
            $('#feclau').datepicker('setDate', validDate);
        }
    });
});
</script>

  
<script type="text/javascript">
                  
        
    function validacp(e)
            {
                var keycar;
                if(window.event)
                    keycar = e.keyCode;
                else
                    if(e.which)
                        keycar=e.which;
                if(keycar>=48 && keycar<=57)
                    return true;
                else
                    return false;
                
            }
            function valida(e)
            {
                var keylet;
                if(window.event)
                    keylet = e.keyCode; /*IE*/
                else
                    if(e.which)
                        keylet = e.which; //Netscape firefox opera
                
                if((keylet>=97&&keylet<=122)||keylet===8 ||keylet===32 || keylet===239 ||keylet>=65&&keylet<=90 ||keylet>=160&&keylet<=163)
                  return true;
                else
                  return false;
            }
		     
                </script>

        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    
                      <%
String nom = (String)session.getAttribute("NombreEmpleado");
String compa = (String)session.getAttribute("nomb");
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
                                                       
							<li><a href="Aperfil.jsp">Perfil</a></li>
							<li>
                                                              <form method="post" action="cerrar">
                                                                
                                                           <input type="submit" value= "logout" >     
                                                            </form> </span></li>
						</ul>
					</nav>
				</header>
            <br><br><br>
		
            
                    
                    
                    <%
String Idsiniestro = (String)session.getAttribute("IdSiniestro");
String compania = (String)session.getAttribute("Compania");
String correoU = (String)session.getAttribute("correoU");
String idvehiculo = (String)session.getAttribute("IdVehiculo");
String asegurado = (String)session.getAttribute("asegurado");
String poliza = (String)session.getAttribute("poliza");
String vigenciapol = (String)session.getAttribute("VigenciaPoliza");
String fechaSiniestro = (String)session.getAttribute("fechaSiniestro");
String fechaapertura = (String)session.getAttribute("fechaAperturaCaso");
String fechaclausura = (String)session.getAttribute("fechaClausuraCaso");
String informe = (String)session.getAttribute("Informe");





String idV = (String)session.getAttribute("idV");
String NombreV = (String)session.getAttribute("NombreV");
String marca = (String)session.getAttribute("marca");
String modelo = (String)session.getAttribute("modelo");
String placas= (String)session.getAttribute("placas");
String numS= (String)session.getAttribute("numS");
String numM= (String)session.getAttribute("numM");
String costo = (String)session.getAttribute("costo");

%>
 <form method="post" action="cambio1" class="container 55%">
                <div style="width:1000px;">
                    <center><h2><b>Edite los campos del siniestro</b></h2> </center>
            <div style="width:500px; float:left;" >
                   
                    <div><h3>Siniestro</h3>
                        <div class="6u 12u$(xsmall)">
                         Id del Siniestro   <input type="text" name="idSiniestro" id="idSiniestro" onKeyPress="return validacp(event)" value="<%=Idsiniestro%>" placeholder="N&uacute;mero de siniestro" required readonly/><br>
                         Id del Vehiculo   <input type="text" name="idVehiculo2" id="idVehiculo2" value="<%=idvehiculo%>" placeholder="N&uacute;mero de veh&iacute;culo" readonly required /><br>
                         Nombre de la compañia   <input type="text" name="compania" id="compania" value="<%=compania%>" placeholder="Compa&ntilde;&iacute;a" required readonly/><br>
                         Correo del usuario   <input type="email" name="correoU" id="correoU" value="<%=correoU%>" placeholder="Correo electr&oacute;nico" required readonly/><br>
                         Nombre del asegurado   <input type="text" name="asegurado" id="asegurado" value="<%=asegurado%>" placeholder="Asegurado" required/><br>
                         Poliza   <input type="text" name="poliza" id="poliza" value="<%=poliza%>" placeholder="P&oacute;liza" required/><br>
                            <div><h3>Vigencia de la Poliza</h3></div><div disabled>
                                <input type="text" name="vipoliza" value="<%=vigenciapol%>" id="vipoliza" required>
                             
                             </div>
                            <div><h3>Fecha del Siniestro</h3></div><div disabled>
                             <input type="text" name="fesi" value="<%=fechaSiniestro%>" id="fesi" required>
                             
                             </div>
                            <div><h3>Fecha de Apertura del Caso</h3></div><div disabled>
                             <input type="text" name="feap" value="<%=fechaapertura%>" id="feap" required>
                             
                             </div>
                            
                            <div><h3>Fecha de Clausura del caso</h3></div><div disabled>
                            <input type="text" name="feclau" value="<%=fechaclausura%>" id="feclau" required>
                             <br><br>
                             <input type="text" name="info" id="info" value="<%=informe%>" placeholder="Notas del informe"/><br>
                             </div>
                                 <h4>Coloque la informacion de su correo</h4>
                                 <input type="email" name="correo2" placeholder="Correo Admimistrador"  required>
                             <input type="password" name="pass" placeholder="Contraseña"  required>
                        </div>
                    </div>
                <br><br>
                            <input class="button enabled" type="submit" value="Cambiar">
                        </div>
            <div style="width:500px; float:right;">
                    <div align="center"><h3>Veh&iacute;culo</h3>
                        <div class="6u 12u$(xsmall)">
                           Id del Vehiculo <input type="text" name="idVehiculo" id="idVehiculo" value="<%=idV%>" placeholder="N&uacute;mero de veh&iacute;culo" onKeyPress="return validacp(event)" onkeyup="especial()" required readonly/><br>
                          Nombre del Vehiculo  <input type="text" name="nombreVehiculo" id="nombreVehiculo" value="<%=NombreV%>" placeholder="Veh&iacute;culo"   required/><br>
                          Marca del Vehiculo  <input type="text" name="marca" d="marca" value="<%=marca%>" placeholder="Marca" required/><br>
                            <div class="select-wrapper">
                                
                               Modelo del Vehiculo <select id="modelo" name="modelo" selected="<%=modelo%>">
                                    <option ><%=modelo%></option>
                                    <script>
                                    var myDate = new Date();
                                    var year = myDate.getFullYear();
                                    for(var i = year+1; i >=1930; i--){
                                            document.write('<option value="'+i+'">'+i+'</option>');
                                    }
                                    </script>
                                </select>
                            </div><br>
                          Placas  <input type="text" name="placas" id="placas" value="<%=placas%>" placeholder="Placas" required/><br>
                          Numero de Serie  <input type="text" name="numeroSerie" id="numeroSerie"  value="<%=numS%>" onKeyPress="return validacp(event)" maxlength="8"  placeholder="N&uacute;mero de serie" required/><br>
                          Numero de motor  <input type="text" name="numeroMotor" id="numeroMotor" value="<%=numM%>" onKeyPress="return validacp(event)" maxlength="8" placeholder="N&uacute;mero de motor" required/><br>
                          Costo  <input type="text" name="costo" id="costo" value="<%=costo%>" onKeyPress="return validacp(event)" maxlength="8"  placeholder="Costo" required/><br><br>
                           
                        </div>
                    </div>
                   
            </div>
                    
                    
                    
                    
                    </div>
                   
            </div>
  
</form>
   </body>
</html>

