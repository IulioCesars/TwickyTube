<!DOCTYPE html>
<html>
	<head>
		<title> Contacto </title>
		<meta charset='utf-8'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href='css/glob-style.css?v=1' type='text/css' rel='stylesheet'>
		<link href='css/idx-style.css?v=1' type='text/css' rel='stylesheet'>
		<script type="text/javascript" src="js/idx-js.js"></script>
	</head>
	<body>
            <jsp:include page="header.jsp" flush="true" />
		<section>
			<div id='idx-login' class='idx-login'>
				<label class='idx-login-gen-label idx-login-title'>Contacto</label>
				<form>
					<label class='idx-login-gen-label idx-login-descrition'> Si tienes alguna duda, problema o comentario, no dudes en contactarnos a la siguiente dirección </label>
					<input class='glob-object-input' type='text' value='soporte.tecnico@twicky.com.mx' readonly />
					<input class='glob-object-input' type='email' placeholder='Aquí va tu correo electronico' required />
					<input class='glob-object-input' type='text' placeholder='Asunto'/>
					<label class='idx-login-gen-label idx-login-descrition'> Escribe tu mensaje en el siguiente campo </label>
					<textarea  class='glob-object-input'> </textarea> 
					<input  class='glob-object-submit glob-object-input-left' type='submit' value='Enviar mensaje'/>
					<button class='glob-object-submit glob-object-submit-right' type='submit' onclick='contacto.html'> Limpiar campos </button>	
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