<%@page import="ADO.UsuarioADO"%>
<%@page import="com.mysql.jdbc.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="VO.Usuario"%>
<%@page import="VO.Video"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ADO.VideoADO"%>
<% 
    String f = request.getParameter("f");
    String fInicio = request.getParameter("fi");
    String fFinal = request.getParameter("ff");
    List<Video> videosBusqueda = new ArrayList<Video>();
    List<Usuario> usuariosBusqueda = new ArrayList<Usuario>();
    if(!StringUtils.isEmptyOrWhitespaceOnly(f)){
        videosBusqueda = VideoADO.BuscarVideos(f, fInicio, fFinal);
        usuariosBusqueda = UsuarioADO.Buscar(f);
    }
    
    List<Video> videosPopulares = VideoADO.ObtenerVideosPopulares();
    List<Video> videosRecientes = VideoADO.ObtenerVideosRecientes();
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    List<Video> videosFavoritos = new ArrayList<Video>();
    List<Video> videosCanalFavorito = new ArrayList<Video>();
    if(usuario != null){
        videosFavoritos = VideoADO.ObtenerFavoritos(usuario.id_usuario);
        videosCanalFavorito = VideoADO.ObtenerVideosCanalFavorito(usuario.id_usuario);
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <title> Dashboard </title>
        <meta charset='utf-8'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href='css/glob-style.css?v=1.1.3' type='text/css' rel='stylesheet'>
        <link href='css/idx-style.css?v=1.1.3' type='text/css' rel='stylesheet'>

        <script src="js/idx-js.js?v=1" type="text/javascript" ></script>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true" />
        
        
        <section onclick="mostrar(true, 'MENU-OPC-OCULTAR');">
            <div id='idx-login' class='idx-login dbd-main'>
                <%if(StringUtils.isEmptyOrWhitespaceOnly(f)) {%>
                <div class='dbd-start'>
                    <label class='idx-login-gen-label dbd-start-title'> Más populares </label>
                    <% for(Video v : videosPopulares){%>
                    <%= v.toHTML() %>
                    <% } %>
                </div>

                <div class='dbd-start'>
                    <label class='idx-login-gen-label dbd-start-title'> Subidas recientes </label>
                    <% for(Video v : videosRecientes){%>
                    <%= v.toHTML() %>
                    <% } %>
                </div>

                <% if(usuario != null) { %>
                    <div class='dbd-start'>
                        <% if(videosFavoritos.size() > 0 ){ %>
                            <label class='idx-login-gen-label dbd-start-title'> Top Favoritos </label>
                        <% } %>
                        <% for(Video v : videosFavoritos){%>
                        <%= v.toHTML() %>
                        <% } %>
                    </div>
                    <div class='dbd-start'>
                        <% if(videosCanalFavorito.size() > 0 ){ %>
                            <label class='idx-login-gen-label dbd-start-title'> Videos de <%= videosCanalFavorito.get(0).fk_usuario %> </label>
                        <% } %>
                        <% for(Video v : videosCanalFavorito){%>
                        <%= v.toHTML() %>
                        <% } %>
                    </div>
                <% } %>
            </div>
            <% } else {%>
                <div class='dbd-start'>
                        <label class='idx-login-gen-label dbd-start-title'>Videos resultado de buscar <%= f %></label>
                        <% for(Usuario u : usuariosBusqueda){%>
                        <%= u.toHTML() %>
                        <% } %>
                </div>
            
                <div class='dbd-start'>
                        <label class='idx-login-gen-label dbd-start-title'>Videos resultado de buscar <%= f %></label>
                        <% for(Video v : videosBusqueda){%>
                        <%= v.toHTML() %>
                        <% } %>
                </div>
            <% } %>
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