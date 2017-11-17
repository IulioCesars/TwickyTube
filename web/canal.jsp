<%@page import="ADO.VideoADO"%>
<%@page import="ADO.UsuarioADO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="VO.Video"%>
<%@page import="VO.Video"%>
<%@page import="VO.Video"%>
<%@page import="VO.Usuario"%>
<%@page import="Helpers.Rutas"%>
<%@page import="com.mysql.jdbc.StringUtils"%>
<%
    String id = request.getParameter("id");
    Usuario usuario = null;
    List<Video> videos = new ArrayList<Video>();
    if(StringUtils.isEmptyOrWhitespaceOnly(id)){
        response.sendRedirect(Rutas.Dashboard);
    }else{
        usuario = UsuarioADO.Obtener(id);
        videos = VideoADO.ObtenerVideosCanal(id);
%>

<!DOCTYPE html>
<html>
	<head>
		<title> Canal </title>
		<meta charset='utf-8'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href='css/glob-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
		<link href='css/idx-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
                <script href ="js/jsUtil.js" type="text/javascript" ></script>
		<script src="js/idx-js.js?v=1" type="text/javascript" ></script>
	</head>
	<body>
		<jsp:include page="header.jsp" flush="true" />

		<section onclick="mostrar(true, 'MENU-OPC-OCULTAR');">
			<div id='idx-login' class='idx-login dbd-main'>
				<div class='dbd-start'>
					<label class='idx-login-gen-label dbd-start-title'> Videos de <%= usuario.id_usuario %> </label>
                                        <% for(Video v : videos){%>
                                        <%= v.toHTML() %>
                                        <% } %>
				</div>
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
<% } %>