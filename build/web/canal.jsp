<%@page import="VO.Reporte"%>
<%@page import="Helpers.Respuestas"%>
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
    }else
    {
        usuario = UsuarioADO.Obtener(id);
        videos = VideoADO.ObtenerVideosCanal(id);
       
    
%>
<% 
    
    Respuestas.setRespuestaReportarUsuario("");
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
                <link href='css/block-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
                <link href='css/canvas-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
                <script>
                    function cerrar_mensaje()
                    {
                        document.getElementById('RespuestaVideo').style = "display:none";
                    }
                    function mostrar_mensaje()
                    {
                        document.getElementById('RespuestaVideo').style = "display:relative";
                    }
                </script>
	</head>
	<body>
		<jsp:include page="header.jsp" flush="true" />
                
		<section onclick="mostrar(true, 'MENU-OPC-OCULTAR');">
			<div id='idx-login' class='idx-login dbd-main'>
                            
                            <div class='cvs-banner'>
                                <img class='cvs-portada' src='MostrarPortada?id=<%=id%>'>
                                <img class='cvs-avatar' src='MostrarAvatar?id=<%=id%>'>
                                <label class='cvs-avatar-name'> <a> <%=usuario.id_usuario%> </a> </label>
                               
                                <!--
                                <form>
                                    <input class='cvs-button cvs-button-reportar' type='hidden' value="<%=usuario.id_usuario%>">
                                    <button class='cvs-button cvs-button-seguir cvs-button-reportar'> Seguir </button>
                                </form>
                                    -->
                                <button onclick='mostrar_mensaje()' class='cvs-button cvs-button-reportar'> Reportar </button>
                                
                            </div>
                            
                            
				<div class='dbd-start'>
					<label class='idx-login-gen-label dbd-start-title'> Videos de <%= usuario.id_usuario %> </label>
                                        <% for(Video v : videos){%>
                                        <%= v.toHTML() %>
                                        <% } %>
				</div>
			</div>
		</section>
		
                <div id='RespuestaVideo' name='finish-upload' class='upl-finish-upload' style='display:none'>
                    <label class='upl-finish-upload-label shadow-center-1004'>
                        <form method='get' action='ReportarUsuario'>
                            ¿Porqué quieres reportar a <%=usuario.id_usuario%>?
                            <input name='<%=Reporte.BD_INDEX.fk_usuario%>' type='hidden' value='<%=usuario.id_usuario%>'>
                            <br><input name='<%=Reporte.BD_INDEX.comentarioReporte%>' class='glob-object-input' type='text' placeholder='Comentario'>
                            <br><input class='glob-object-submit' type='submit' value='Enviar reporte'>
                            <input class='glob-object-submit' type='button' onclick='cerrar_mensaje()' value='Cerrar'>
                        </form>
                    </label>
                </div>
            <%= Respuestas.getRespuestaReportarUsuario() %>
            <jsp:include page="footer.jsp" flush="true" />
	</body>
</html>
<% } %>