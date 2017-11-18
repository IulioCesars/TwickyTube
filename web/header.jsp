
	<link href='css/glob-style.css?v=1.1.3' type='text/css' rel='stylesheet'>
	<script src="js/header.js?v=1" type="text/javascript"></script>
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>

<%

    VO.Usuario usuario = (VO.Usuario) session.getAttribute("usuario");
    if(usuario == null){
    
    }
%>


<header>
	<nav class='glob-header'>
                <form action="Busqueda" method="GET">
			<a class='glob-header-logo' href='dashboard.jsp'> 
                            <img src='resources/images/TwickyTube_01.png'> 
                        </a>
			<% if(usuario != null) {%>
                            <button type='button' onclick="mostrar_header('MENU-OPC-02');" class='glob-header-menu glob-object-submit-right'> 
                                &#8801; 
                            </button>
                            <label onclick="location='perfil.jsp'" class='glob-header-menu glob-object-submit-right glob-label-user'>
                                <%= usuario.id_usuario %>
                            </label>
                            <button type='button' onclick="mostrar_header('MENU-OPC-01');" class='glob-header-avatar-button glob-object-submit-right' type='button'> 
                                    <img  class='glob-header-avatar-img' src='MostrarAvatar?id=<%= usuario.id_usuario %>'/>
                            </button>
                            <img class='glob-header-upload glob-object-submit-right' src='resources/images/upload.png' onclick="location='upload.jsp'">
			<% } %>
                        <% if(usuario == null) {%>
                            <button type='button' onclick="location='index.jsp'" class='glob-object-button-login' type='button'> 
                                    Iniciar sesión
                            </button>
                        <% } %>
                        <div class='glob-header-search'>
                                <button name = "btnBuscar" type='button' class='glob-header-search-button glob-header-avatar-button' type='button'><img class='glob-header-search-img' src='resources/images/search.png'/></button>
                                <input name = "txtBusqueda" class='glob-header-search-input' type='search' placeholder='Buscar...' />
			</div>
		</form>
	</nav>
	<ul id='glob-header-menu-02' class='glob-header-menu-list'>
                <% if(usuario != null) {%>
		<li><a href='canal.jsp?id=<%= usuario.id_usuario %>'> Mi canal </a></li>
		<li><a href='perfil.jsp'> Mi perfil </a></li>
		<li><a href='favoritos.jsp'> Favoritos </a></li>
                <li><a href='reportes.jsp'> Reportes de usuarios </a></li>
		<li><a href='subscripciones.jsp'> Subscripciones </a></li>
		<li><a href='subscriptores.jsp'> Subscriptores </a></li>
		<li><a href='CerrarSesion'> Cerrar sesión </a></li>
                <% } %>
	</ul>
	<ul id='glob-header-menu-01' class='glob-header-menu-list'>
		<li> Subir un video </li>
		<li> Cambiar mi avatar </li>
		<li> Cambiar mi portada </li>		
	</ul>
</header>
