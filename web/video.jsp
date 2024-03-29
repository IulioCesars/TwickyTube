<%@page import="java.util.ArrayList"%>
<%@page import="ADO.ComentarioADO"%>
<%@page import="VO.Comentario"%>
<%@page import="java.util.List"%>
<%@page import="ADO.UsuarioADO"%>
<%@page import="VO.Usuario"%>
<%@page import="Helpers.Util"%>
<%@page import="VO.Video"%>
<%@page import="ADO.VideoADO"%>
<%@page import="Helpers.Rutas"%>
<%@page import="com.mysql.jdbc.StringUtils"%>
<% 
    String idString = request.getParameter("id");
    Integer id = 0;
    Video video = null;
    Usuario usuario = null;
    List<Video> videosRelacionados = new ArrayList<Video>();
    id = Util.StringTryParsetoInt(idString);
    if(id != null){
        video = VideoADO.Obtener(id);
        if(video != null){
            usuario = UsuarioADO.Obtener(video.fk_usuario);
            videosRelacionados = VideoADO.ObtenerVideosRecientes();
        }
    }
    Usuario usuarioSession = (Usuario) session.getAttribute("usuario");
    List<Comentario> comentarios = ComentarioADO.ObternerComentarios(video.id_video);
%>

<% if(  video != null 
        && usuario != null) {
%>

<!DOCTYPE html>
<html>
    <head>
        <title><%= video.titulo %></title>
        <meta charset='utf-8'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href='css/glob-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
        <link href='css/idx-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
        <script src="js/idx-js.js?v=1" type="text/javascript" ></script>
        <script src='js/vid-obtenerURL.js?v=1.1.2' type="text/javascript"></script>
        <script src ="js/jsUtil.js" type="text/javascript" ></script>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true" />
	<section onclick="mostrar(true, 'MENU-OPC-OCULTAR');">
			<div id='idx-login' class='idx-login dbd-main'>
				
				<div class='vid-main'>
					<video class='vid-main-content' controls> 
                                            <source src="<%= video.pathVideo %>"><!--resources/video/video_01.mp4--> 
					</video>
					
					<div class='vid-main-sub'>
						<label class='idx-login-gen-label vid-main-title'><%= video.titulo %></label>
						
						
						<span class='vid-main-subcontent'>
							<img class='vid-main-sub-img' src='MostrarAvatar?id=<%= usuario.id_usuario %>'/>
                                                        <label class='vid-main-sub-name'><a class='vid-main-user-link' href='canal.jsp?id=<%= video.fk_usuario %>'> <%= usuario.id_usuario %> </a></label>
                                                        <label> <%= video.descripcion %> </label>

                                                        <% if(usuarioSession != null
                                                                && usuarioSession.id_usuario != usuario.id_usuario) {
                                                                boolean seguir =  false;
                                                                seguir = UsuarioADO.BuscarSeguidor(usuarioSession.id_usuario, usuario.id_usuario);
                                                                
                                                                String textoSubs = seguir ? "Dejar de seguir" : "Suscribirse" ;
                                                                String cssSubs = seguir ? "style='background-color:#ff0000;'" : "";
                                                        %>
							<button type='button' id="btnSuscribirse" class='vid-main-sub-button' <%= cssSubs %> onclick='jsUtil.Suscribirse("<%= usuario.id_usuario %>")'>
                                                            <%= textoSubs %>
                                                        </button>
                                                        <% } %>
						</span>
						<span class='vid-main-subcontent vid-main-like'>
                                                        <% if(usuarioSession != null
                                                                    && usuarioSession.id_usuario != usuario.id_usuario) {
                                                                boolean megusta = false;
                                                                megusta = VideoADO.BuscarLike(usuarioSession.id_usuario, video.id_video);
                                                        %>
                                                        
                                                        <button class='vid-main-like-button' title='Compartir'onclick="jsUtil.Compartir(<%= video.id_video %>)" ><img src='resources/images/Compartir.png'> </button>                                                            
                                                        <button class='vid-main-like-button' title='Reportar' onclick="jsUtil.Reportar(<%= video.id_video %>)" ><img src='resources/images/report_01.png'> </button>
                                                        <label id="lblLike" class='vid-main-like-label'><%= video.megusta %></label>
                                                        <button class='vid-main-like-button' title='Me gusta' onclick="jsUtil.MeGusta(<%= video.id_video %>)" ><img id="btnLike" src='resources/images/<%if(!megusta) {%>like_01.png<% } else {%>dislike_01.png <% } %>' > </button>
                                                        <!--<label class='vid-main-like-label'>9M</label>-->
							<button class='vid-main-like-button' title='Favoritos'onclick="jsUtil.Favorito(<%= video.id_video %>)" ><img src='resources/images/favorites_01.png'> </button>

                                                        <% } %>
                                                </span>
                                                <span class='vid-main-subcontent vid-main-like vid-main-like-visitas'>
                                                    <strong>Visitas <%= video.vistas %></strong>
                                                </span>
						
					</div>
					
                                        <div id="divComentarios" class='vid-main-sub vid-main-coments'>
                                                <% if(usuarioSession!=null){%>
						<div class='glob-separate-top-bottom'>
							<img class='vid-main-coments-img' onclick='mostrar_x();' src="MostrarAvatar?id=<%= usuarioSession.id_usuario %>">
                                                        <label class='vid-main-coments-user'> <a href='canal.jsp?id=<%= usuarioSession.id_usuario %>'><%= usuarioSession.id_usuario %></a></label>
                                                        <br>
                                                        <textarea id="txtComentarios" rows="4" cols="50" placeholder="Escribe aqui tu comentario"></textarea>
                                                        <button type='button' class='   ' onclick='jsUtil.Comentar( $("#txtComentarios").val() ,"<%= video.id_video %>")'> Comentar </button>
						</div>
                                                <% } %>
                                                
                                                <% for(Comentario c : comentarios){ %>
						<div class='glob-separate-top-bottom'>
							<img class='vid-main-coments-img' onclick='mostrar_x();' src="MostrarAvatar?id=<%= c.fk_usuario %>">
							<label class='vid-main-coments-user'> <a href='canal.jsp?id=<%= c.fk_usuario %>'><%= c.fk_usuario %></a> <label class='vid-main-coments-date'><%= c.fecha.toString() %></label> </label>
							<label class='vid-main-coments-coment'><%= c.comentario %></label>
						</div>
						<% } %>
					</div>
				</div>
				
                                        
                                <div class='vid-main vid-recomended'>
                                    <% for(Video v : videosRelacionados){ %>
                                    <span class='dbd-start-span'>
                                        <a href='video.jsp?id=<%= v.id_video %>' class='dbd-start-video-label'>
                                            <img class='dbd-start-video-label-content' src='<%= v.pathVistaPrevia %>'/>
                                            <label class='dbd-start-video-label-title'><%= v.titulo %></label>
                                            <label class='dbd-start-video-label-user'> <%= v.fk_usuario %> </label> 
                                        </a>
                                    </span>
                                    <% } %>
				</div>
			</div>
			
			
		</section>
        <jsp:include page="footer.jsp" flush="true" />
    </body>
</html>
<% }
else{
    response.sendRedirect(Rutas.Dashboard);
}
%>