<%@page import="Helpers.Rutas"%>
<%@page import="ADO.UsuarioADO"%>
<%@page import="VO.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if(usuario != null){
        usuario = UsuarioADO.Obtener(usuario.id_usuario);
    }
    if(usuario == null){
        response.sendRedirect(Rutas.Dashboard);
    }
    else {
%>
<!DOCTYPE html>
<html>
	<head>
		<title> Perfil </title>
		<meta charset='utf-8'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href='css/glob-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
		<link href='css/idx-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
		
		<script src="js/idx-js.js?v=1" type="text/javascript" ></script>
		<!--
		<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
-->
	</head>
	<body>
            <jsp:include page="header.jsp" flush="true" />	
		<!--
		<section onclick="mostrar(true, 'MENU-OPC-OCULTAR');">
	
		-->
                <form action="EditarUsuario" method='POST' enctype='multipart/form-data' >
		<section onclick="mostrar(true, 'MENU-OPC-OCULTAR');">
                    <div id='idx-login' class='idx-login dbd-main per-content'>
                        <div class='dbd-start per-start-p'>
                            <span class='per-panel-01'>
                                    <img class='per-panel-01-w100 per-panel-01-img' src='MostrarAvatar?id=<%= usuario.id_usuario %>'>
                                    <input class='per-panel-01-w100 center-text' type='text' value='<%= usuario.correo %>' readonly />
                                    <input class='per-panel-01-w100 center-text per-lbl-alias' type='text' value='<%= usuario.id_usuario %>' readonly />
                            </span>
                            <span class='per-panel-03'>
                                <img src='MostrarPortada?id=<%= usuario.id_usuario %>'>
                            </span>
                            <form action="" method="" enctype="multipart/form-data">
                            <span class='dbd-start-span per-start per-panel-02'>
                                <div class='per-panel-02-into'>
                                        <span class='per-panel-input'>
                                            <label id='reg-dat-fecha-nac' name='fecha-nac' class='idx-login-gen-label idx-login-description'>
                                                Fecha de Nacimiento 
                                            </label>
                                            <input id='per-date' name="fNacimiento" class='glob-object-input habilita-deshabilita' type='date' value="<%= new SimpleDateFormat("yyyy-MM-dd").format(usuario.fecha_nacimiento)%>" disabled requiered/> 	
                                        </span>
                                        <span class='per-panel-input'>
                                            <label class='idx-login-gen-label idx-login-description'>
                                                Genero
                                            </label>
                                            <select required id='per-sel-genero' name='genero' class='glob-object-input habilita-deshabilita' disabled > 
                                                <option selected hidden><% if(usuario.genero.equals("M"))%>Masculino<% else %>Femenino</option>
                                                <option value='M'>Masculino</option>
                                                <option value='F'>Femenino</option>
                                                <!--<option> Prefiero no especificar </option>-->
                                            </select>						
                                        </span>
                                        <span class='per-panel-input'>
                                            <label class='idx-login-gen-label idx-login-description'>
                                                Ciudad
                                            </label>
                                            <select required id='per-sel-ciudad' name='ciudad' text="AAA" class='glob-object-input habilita-deshabilita' disabled > 
                                                <option selected hidden> <%= usuario.ciudad %> </option>
                                                <option> Apodaca </option>
                                                <option> Cienega de Flores </option>
                                                <option> Escobedo </option>
                                                <option> Garcia </option>
                                                <option> Guadalupe </option>
                                                <option> Juarez </option>
                                                <option> Monterrey </option>
                                                <option> San Nicolas </option>
                                                <option> San Pedro Garza Garcia </option>
                                            </select>

                                        </span>
                                        <span class='per-panel-input'>
                                            <label class='idx-login-gen-label idx-login-description'>
                                                Pais
                                            </label>
                                            <select required id='per-sel-pais' name='pais' class='glob-object-input habilita-deshabilita' disabled >
                                                <option selected hidden> <%= usuario.pais %> </option>
                                                <option> Mexico </option>
                                                <option> Estados Unidos de America</option>
                                            </select>
                                        </span>

                                        <span class='per-panel-input'>
                                            <!--
                                            <label class='idx-login-gen-label idx-login-description'>
                                                ContraseÒa 
                                            </label>
                                            -->
                                            <input required id='reg-psw-contrasenia-01' name='contrasenia' class='glob-object-input per-psw habilita-deshabilita' type='hidden' placeholder='ContraseÒa' disabled />
                                        </span>
                                        
                                        
                                        <span class='per-panel-input per-panel-input-portada'>
                                            <label class='idx-login-gen-label idx-login-description'>
                                                Imagen de portada
                                            </label>
                                            <input required	id='reg-img-portada' name='img-portada' class='glob-object-input habilita-deshabilita' type='file' disabled >
                                            <output id='reg-output-img-portada' class='reg-output-img-portada habilita-deshabilita' disabled></output>
                                        </span>
                                        <span class='per-panel-input per-panel-input-img'>
                                            <label class='idx-login-gen-label idx-login-description'>
                                                Imagen de avatar
                                            </label>
                                            <input required	id='reg-img-avatar' name='img-avatar' class='glob-object-input habilita-deshabilita' type='file' disabled >
                                            <output id='reg-output-img-avatar' class='reg-output-img-avatar habilita-deshabilita' disabled></output>
                                        </span>
                                        
                                        <div class='per-block'>
                                            <input id='reg-btn-registrarme' name='registrarme' class='glob-object-submit glob-object-submit-right per-object-submit per-object-save' type='submit' value='Guardar' disabled />
                                            <button id='reg-btn-regresar' name='regresar' class='glob-object-submit glob-object-submit-right per-object-submit per-object-edit' type='button' onclick="habilitar('PERFIL');"> Editar </button>	
                                        </div>
                                                
                                        <!--
                                        <div class='per-block'>
                                            <input id='reg-btn-registrarme' name='registrarme' class='glob-object-submit glob-object-submit-right per-object-submit per-object-save' type='submit' value='Guardar' disabled />
                                            <button id='reg-btn-regresar' name='regresar' class='glob-object-submit glob-object-submit-right per-object-submit per-object-edit' type='button' onclick="habilitar('PERFIL');"> Editar </button>	
                                        </div>
                                        -->
                                    </div>
                            </span>
                            </form>        
                        </div>
                    </div>
		</section>
                </form>
		<footer>
			<div class='glob-footer'>
				
				<div>
					<label>Conocenos</label>
					<ul>
						
						<li><a href='about.html'>Acerca de</a></li>
						<li><a href='privacity.html'>Privacidad</a></li>
						<li><a href='contacto.html'> Contacto </a></li>
						<li><a href='index.html'> Inicio</a></li>
					</ul>
				</div>
					
				<div>
                                    <label>Otros sitios</label>
                                    <ul>

                                        <li><a href='#'>Twicky Games</a></li>
                                        <li><a href='http://www.twicky.com.mx/lab'>Twicky Lab</a></li>
                                        <li><a href='http://www.twicky.com.mx'>Twicky</a></li>

                                    </ul>
				</div>
			
				<div class='glob-footer-footer'>
                                    <label> &#169; Twicky 2017</label>
				</div>
			</div>
			
		</footer>

	</body>
</html>
<script>

function archivo_avatar(evt) 
{
	var files = evt.target.files; // FileList object
   
	//Obtenemos la imagen del campo "file". 
	for (var i = 0, f; f = files[i]; i++) 
	{         
		//Solo admitimos im√°genes.
		if (!f.type.match('image.*')) 
		{
			continue;
		}
   
		var reader = new FileReader();
	   
		reader.onload = (function(theFile) 
		{
		   return function(e) 
		   {
				// Creamos la imagen.
				document.getElementById("reg-output-img-avatar").innerHTML = ['<img class=glob-object-input src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
		   };
	   })(f);

	   reader.readAsDataURL(f);
	}
}
	
	
function archivo_portada(evt) 
{
	var files = evt.target.files; // FileList object
   
	//Obtenemos la imagen del campo "file". 
	for (var i = 0, f; f = files[i]; i++) 
	{         
		//Solo admitimos im√°genes.
		if (!f.type.match('image.*')) 
		{
			continue;
		}
   
		var reader = new FileReader();
	   
		reader.onload = (function(theFile) 
		{
		   return function(e) 
		   {
				// Creamos la imagen.
				document.getElementById("reg-output-img-portada").innerHTML = ['<img class=glob-object-input src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
		   };
	   })(f);

	   reader.readAsDataURL(f);
	}
}
	
	document.getElementById('reg-img-avatar').addEventListener('change', archivo_avatar, false);
	document.getElementById('reg-img-portada').addEventListener('change', archivo_portada, false);

</script>
<% } %>