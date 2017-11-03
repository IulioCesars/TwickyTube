<!DOCTYPE html>
<html>
	<head>
		 <script>
            function validacionCamposVacios()
            {
                if (document.getElementById('reg-psw-contrasenia-01').value == document.getElementById('reg-psw-contrasenia-02').value) 
                {
                    return true;
                }
                else 
                {
                    alert('LAS CONTRASE�AS NO COINCIDEN, vuelve a escribirlas u.u'); 
                    return false;
                }
            }
		</script>
		<title> Inicio de sesion </title>
		<meta charset='utf-8'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href='css/glob-style.css' type='text/css' rel='stylesheet'>
		<link href='css/idx-style.css' type='text/css' rel='stylesheet'>
		<script type="text/javascript" src="js/idx-js.js?v=1.1.2"></script>
	</head>
	<body>
<!--		<header>
			<nav class='glob-header'>
				<a href='#'> <img src='resources/TwickyTube_01.png'> </a>
				<a href='#'></a>
				<a href='#'></a>
				<a href='#'></a>
				<a href='#'></a>
			</nav>
		</header>
-->
		<section>
			<div id='idx-login' class='idx-login shadow-center-1004'>
				<img class='idx-login-img' src='resources/images/TwickyTube_01.png'/>				
				<label class='idx-login-gen-label idx-login-title'> Inicio de sesi�n </label>
				<form action='IniciarSesion' method="POST">
					<input id='idx-txt-correo' name='correo' class='glob-object-input' type='email' placeholder='Correo Electronico' />
					<input id='idx-psw-contrasenia' name='contrasenia' class='glob-object-input' type='password' placeholder='Contrase�a' />
					<label class='idx-login-gen-label idx-login-description'><input id='idx-recordar' name='recordar' type='checkbox'/> Recordar contrase�a</label>
					<input id='idx-btn-iniciar-sesion' name='iniciar-sesion' class='glob-object-submit glob-object-submit-left' type='submit' value='Iniciar sesi�n'/>
					<button id='idx-btn-registrar' name='registrar' class='glob-object-submit glob-object-submit-right' type='button' onclick="mostrar(true, 'LOG-REG');"> Registro de usuario </button>	
					<a href='recovery.html'> �Olvidaste tu contrase�a? </a>
				</form>
				
			</div>

			<hr> 

			<div id='idx-singup' class='idx-singup idx-login shadow-center-1004'>
				<img class='idx-login-img' src='resources/images/TwickyTube_01.png'/>
				<label class='idx-login-gen-label idx-login-title'> Registro de usuario <br><b> Obligatorio *<b></label>
				<form action="CrearUsuario" method='POST' enctype='multipart/form-data' onsubmit='return validacionCamposVacios(this);'>
					<input id='reg-txt-alias' name='alias' class='glob-object-input' type='text' placeholder='Alias *'/>
					<input id='reg-txt-correo' name='correo' class='glob-object-input' type='email' placeholder='Correo Electronico *'/>
					<input id='reg-psw-contrasenia-01' name='contrasenia' class='glob-object-input' type='password' placeholder='Contrase�a'/>
					<input id='reg-psw-contrasenia-02' name='contrasenia' class='glob-object-input' type='password' placeholder='Repetir contrase�a'/>
					<label id='reg-dat-fecha-nac' name='fecha-nac' class='idx-login-gen-label idx-login-description'>Fecha de Nacimiento <br> <input class='glob-object-input' type='date'/> </label>
					<label class='idx-login-gen-label idx-login-description'>
					Genero
					<select id='reg-sel-genero' name='genero' class='glob-object-input'> 
						<option> Masculino </option>
						<option> Femenino </option>
						<option> Prefiero no especificar </option>
					</select>
					</label>

					<label class='idx-login-gen-label idx-login-description'>
					Ciudad
					<select id='reg-sel-ciudad' name='ciudad' class='glob-object-input'> 
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
					</label>

					<label class='idx-login-gen-label idx-login-description'>
					Pais
					<select id='reg-sel-pais' name='pais' class='glob-object-input'>
						<option> México </option>
						<option> Estados Unidos de América</option>
					</select>
					</label>

					<label class='idx-login-gen-label idx-login-description'>
					Imagen de avatar
					<input 	id='reg-img-avatar' name='img-avatar' class='glob-object-input' type='file'>
					<output id='reg-output-img-avatar'></output>
					</label>
					<label class='idx-login-gen-label idx-login-description'>
					Imagen de portada
					<input 	id='reg-img-portada' name='img-portada' class='glob-object-input' type='file'>
					<output id='reg-output-img-portada'></output>
					</label>
					
					<label class='idx-login-gen-label idx-login-description'>
						Elige una pregunta de seguridad
						<select id='reg-sel-pregunta-seg-01' name='pregunta-seg-01' class='glob-object-input'>
							<option value='1'> �Cu�l fue tu primera mascota? </option>
							<option value='2'> �Cu�l es tu color favorito? </option>
							<option value='3'> �Cu�l es el NIP de tu tarjeta de cr�dito? </option>
							<option value='4'> �Donde vives y en que horarios no est�s en tu casa? </option>
							<option value='5'> �Cu�l es tu clave de acceso para entrar a Facebook? </option>
						</select>
					</label>
					<input id='reg-txt-respuesta-01' name='respuesta-01' class='glob-object-input' type='text' placeholder='Respuesta *'/>
					
					<input id='reg-btn-registrarme' name='registrarme' class='glob-object-submit glob-object-submit-left' type='submit' value='Registrarme'/>
					<button id='reg-btn-regresar' name='regresar' class='glob-object-submit glob-object-submit-right' type='button' onclick="mostrar(false, 'LOG-REG');"> Regresar </button>	
				</form>
			</div>
		</section>

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
		//Solo admitimos imágenes.
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
		//Solo admitimos imágenes.
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