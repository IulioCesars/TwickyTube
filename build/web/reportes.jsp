<!DOCTYPE html>
<html>
	<head>
		<title> Acerca des </title>
		<meta charset='utf-8'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href='css/glob-style.css?v=1' type='text/css' rel='stylesheet'>
		<link href='css/idx-style.css?v=1.1' type='text/css' rel='stylesheet'>
		<script type="text/javascript" src="js/idx-js.js"></script>
	</head>
	<body>
<jsp:include page="header.jsp" flush="true" />
		<section onclick="mostrar(true, 'MENU-OPC-OCULTAR');">
			<div id='idx-login' class='idx-login dbd-main'>
                            <div class='dbd-start'>
                                <section id='reg-header'>
                                    <label class='idx-login-gen-label dbd-start-title rep-head'> 
                                        <label class='rep-head-title'> Usuarios reportados </label>
                                        <label class='rep-head-filter'>
                                            <label>
                                                Filtrar por:
                                                <select class='rep-head-objects'>
                                                    <option>Comentarios</option>
                                                    <option>Videos</option>
                                                </select>
                                            </label>
                                            <label>
                                                Orden:
                                                <select class='rep-head-objects'>
                                                    <option>Ascendente</option>
                                                    <option>Descendente</option>
                                                </select>
                                            </label>
                                            <label>
                                                Resultados:
                                                <select class='rep-head-objects'>
                                                    <option>10</option>
                                                    <option>20</option>
                                                    <option>30</option>
                                                    <option>40</option>
                                                    <option>50</option>
                                                    <option>Todos</option>
                                                </select>
                                            </label>
                                                <button type='button' class='rep-head-objects rep-head-buttons'> Anterior </button>
                                                <button type='button' class='rep-head-objects rep-head-buttons'> Siguiente </button>
                                        </label>
                                    </label>
                                </section>
                                <section id='rep-registros'>
                                
                                    <span class='rep-body-row'>
                                        <img class='rep-body-row-image' src='resources/images/esteban.jpg'>
                                        <span class='rep-body-row-tipoPost'><strong>Tipo de post: </strong> Comentario </span>
                                        <label class='rep-body-row-date-title'> <strong>Tiempo de bloqueo:</strong> </label>
                                        <input class='rep-body-row-date' type="date" disabled="true"/>
                                        <label class='rep-body-row-date-checkbox'><strong>Indefinido - </strong><input type="checkbox" checked="checked"/></label>
                                        <label class='rep-body-row-user'> <strong>Usuario:</strong> Esteban Carraza</label>
                                        <label class='rep-body-row-date-title'> <strong>Razon de bloqueo:</strong> </label>
                                        <select class='rep-body-row-date-title'> 
                                            <option>Video no apropiado</option>
                                            <option>Odio los gatos</option>
                                            <option>Porque si >:v</option>
                                        </select>
                                        <button class='rep-body-row-date-button' type='button'> Bloquear </button>
                                        <span class='rep-body-row-post'><strong>Reporte: </strong> Eso es muy ofensivo alv D:< </span>
                                        <span class='rep-body-row-post'>
                                            <strong class='rep-body-row-post-title'>Post: </strong> 
                                            <span  class='rep-body-row-post-body'> 
                                                Hola como estas? :D
                                                Hola como estas? :D
                                                Hola como estas? :D
                                                Hola como estas? :D
                                                Hola como estas? :D
                                                Hola como estas? :D
                                                Hola como estas? :D
                                            </span>
                                        </span>
                                    </span>
                                    
                                    <span class='rep-body-row'>
                                        <img class='rep-body-row-image' src='resources/images/esteban.jpg'>
                                        <span class='rep-body-row-tipoPost'><strong>Tipo de post: </strong> Comentario </span>
                                        <label class='rep-body-row-date-title'> <strong>Tiempo de bloqueo:</strong> </label>
                                        <input class='rep-body-row-date' type="date" disabled="true"/>
                                        <label class='rep-body-row-date-checkbox'><strong>Indefinido - </strong><input type="checkbox" checked="checked"/></label>
                                        <label class='rep-body-row-user'> <strong>Usuario:</strong> Esteban Carraza</label>
                                        <label class='rep-body-row-date-title'> <strong>Razon de bloqueo:</strong> </label>
                                        <select class='rep-body-row-date-title'> 
                                            <option>Video no apropiado</option>
                                            <option>Odio los gatos</option>
                                            <option>Porque si >:v</option>
                                        </select>
                                        <button class='rep-body-row-date-button' type='button'> Bloquear </button>
                                        <span class='rep-body-row-post'><strong>Reporte: </strong> Eso es muy ofensivo alv D:< </span>
                                        <span class='rep-body-row-post'>
                                            <strong class='rep-body-row-post-title'>Post: </strong> 
                                            <span  class='rep-body-row-post-body'> 
                                                <video src='resources/video/video_01.mp4' controls></video>
                                            </span>
                                        </span>
                                    </span>
                                    
                                </section>
                                
                                
                            </div>
                        </div>
                </section>
		<jsp:include page="footer.jsp" flush="true" />

	</body>
</html>