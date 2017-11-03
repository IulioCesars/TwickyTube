<!DOCTYPE html>
<html>
	<head>
		<title> Recuperar contrasña </title>
		<meta charset='utf-8'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href='css/glob-style.css' type='text/css' rel='stylesheet'>
		<link href='css/idx-style.css' type='text/css' rel='stylesheet'>
		<script type="text/javascript" src="js/idx-js.js"></script>
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
			<label class='idx-login-gen-label idx-login-title'> Recuperación de contraseña </label>
			<form method='post' onsubmit='return validacionCamposVacios(this);'>
				<label class='idx-login-gen-label idx-login-description'>
						Elige una pregunta de seguridad
						<select id='reg-sel-pregunta-seg-01' name='pregunta-seg-01' class='glob-object-input' required>
							<option value='1'> ¿Cuál fue tu primera mascota? </option>
							<option value='2'> ¿Cuál es tu color favorito? </option>
							<option value='3'> ¿Cuál es el NIP de tu tarjeta de crédito? </option>
							<option value='4'> ¿Donde vives y en que horarios no estás en tu casa? </option>
							<option value='5'> ¿Cuál es tu clave de acceso para entrar a Facebook? </option>
						</select>
					</label>
					<input id='reg-txt-respuesta-01' name='respuesta-01' class='glob-object-input' type='text' placeholder='Respuesta *' required/>
					<input id='reg-psw-contrasenia-01' name='contrasenia' class='glob-object-input' type='password' placeholder='Contraseña *' required/>
					<input id='reg-psw-contrasenia-02' name='contrasenia' class='glob-object-input' type='password' placeholder='Repetir contraseña *' required/>
					<input id='reg-btn-contrasenia' name='contrasenia' class='glob-object-submit glob-object-submit-left' type='submit' value='Cambiar contraseña'/>
					<button id='reg-btn-regresar' name='regresar' class='glob-object-submit glob-object-submit-right' type='button' onclick="ir_a(1)"> Regresar </button>	
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