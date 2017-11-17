<%@page import="VO.Reporte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ADO.ReporteADO"%>
<%
    String orden;
    int limite1;
    int limite2;
    String clasificacion;
    try
    {
        orden = (String) request.getParameter("orden");
        limite1 =  Integer.parseInt(request.getParameter("pi"));
        limite2 = Integer.parseInt(request.getParameter("pf"));
        clasificacion = (String) request.getParameter("clasificacion");
    }
    catch (Exception ex)
    {
        orden = "ASC";
        limite1 = 0;
        limite2 = 5;
        clasificacion = "Para todo publico";
    }
    
    
    List<Reporte> lista_reporte = ReporteADO.mostrar_reportes
        (
               orden, 
               limite1, 
               limite2,
               clasificacion
        );
%>
<!DOCTYPE html>
<html>
	<head>
		<title> Acerca des </title>
		<meta charset='utf-8'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href='css/glob-style.css?v=1' type='text/css' rel='stylesheet'>
		<link href='css/idx-style.css?v=1.1' type='text/css' rel='stylesheet'>
		<script type="text/javascript" src="js/idx-js.js"></script>
                <script src='js/jquery-3.2.1.min.js'></script>
                <script>
                     function anterior()
                    {
                        var pi = document.getElementById('rep-input-pi').value;
                        var limiteS = document.getElementById('rep-sel-limite').value;
                        var ordenS = document.getElementById('rep-sel-orden').value;
                        if(ordenS == "Ascendente") ordenS = "ASC";
                        if(ordenS == "Descendente") ordenS = "DESC";
                        var tipoS = document.getElementById('rep-sel-tipo').value;
                        
                        pi = parseInt(pi) - limiteS;
                        limiteS = parseInt(pi) - limiteS;
                        
                        if(parseInt(limiteS) < parseInt(pi))
                        {
                            pi = 0;
                            limiteS = 1;
                        }
                        
                        window.location = 'reportes.jsp?orden=' + ordenS + '&pi=' + pi + '&pf=' + limiteS + '&tipo=' + tipoS ;
                    }
                    function siguiente()
                    {
                        var pi = document.getElementById('rep-input-pi').value;
                        var limiteS = document.getElementById('rep-sel-limite').value;
                        var ordenS = document.getElementById('rep-sel-orden').value;
                        if(ordenS == "Ascendente") ordenS = "ASC";
                        if(ordenS == "Descendente") ordenS = "DESC";
                        var tipoS = document.getElementById('rep-sel-tipo').value;
                        
                        pi = parseInt(pi) + parseInt(limiteS);
                        limiteS = parseInt(pi) + parseInt(limiteS);
                        
                        window.location = 'reportes.jsp?orden=' + ordenS + '&pi=' + pi + '&pf=' + limiteS + '&tipo=' + tipoS ;
                    }
                    function filtros()
                    {
                        var pi = document.getElementById('rep-input-pi').value;
                        var ordenS = document.getElementById('rep-sel-orden').value;
                        if(ordenS == "Ascendente") ordenS = "ASC";
                        if(ordenS == "Descendente") ordenS = "DESC";
                        
                        var limiteS = document.getElementById('rep-sel-limite').value;
                        
                        
                        var tipoS = document.getElementById('rep-sel-tipo').value;
                        
                        window.location = 'reportes.jsp?orden=' + ordenS + '&pi=' + pi + '&pf=' + limiteS + '&tipo=' + tipoS ;
                    }
                    /*
                    $(document).ready(function()
                    {
                       $(".chk-indefinido:checked")
                       {
                            $(".ipt-date").prop("disabled", true);
                       }
                        
                    });
                      */      
                    
                </script>
	</head>
	<body>
            <input id='rep-input-pi' type='hidden' value='<%=limite1%>'>
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
                                                <select class='rep-head-objects' id='rep-sel-tipo'>
                                                    <option>Para todo publico</option>
                                                    <option>Para mayores de 13</option>
                                                    <option>Para mayores de 15</option>
                                                    <option>Para mayores de 18</option>
                                                </select>
                                            </label>
                                            <label>
                                                Orden:
                                                <select class='rep-head-objects' id='rep-sel-orden'>
                                                    <option>Ascendente</option>
                                                    <option>Descendente</option>
                                                </select>
                                            </label>
                                            <label>
                                                Resultados:
                                                <select class='rep-head-objects' id='rep-sel-limite'>
                                                    <option>1</option>
                                                    <option>5</option>
                                                    <option>10</option>
                                                    <option>20</option>
                                                    <option>30</option>
                                                    <option>40</option>
                                                    <option>50</option>                                                    
                                                </select>
                                            </label>
                                            <button id='rep-btn-filtrar' name='btn-filtrar' onclick='filtros()' type='button' class='rep-head-objects rep-head-buttons'> Filtrar </button>
                                                <button onclick='anterior()' type='button' class='rep-head-objects rep-head-buttons'> Anterior </button>
                                                <button onclick='siguiente()' type='button' class='rep-head-objects rep-head-buttons'> Siguiente </button>
                                        </label>
                                    </label>
                                </section>
                                <section id='rep-registros'>
                                
                                     <% for(Reporte r : lista_reporte){%>
                                        <%= r.ImprimeRegistrotoHTML() %>
                                    <% } %>
                                    
                                    <!--
                                    <span class='rep-body-row'>
                                        
                                        <img class='rep-body-row-image' src='resources/images/esteban.jpg'>
                                        <article class='rep-body-row-row'>
                                            <span class='rep-body-row-tipoPost'><strong>Tipo de post: </strong> Comentario </span>
                                            <section>
                                                <label class='rep-body-row-date-title'> <strong>Bloquear hasta:</strong> </label>
                                                <input class='rep-body-row-date' type="date" disabled="true"/>
                                                <label class='rep-body-row-date-checkbox'><strong>Indefinido - </strong><input type="checkbox" checked="checked"/></label>
                                            </section>
                                        </article>

                                        <article class='rep-body-row-row'>
                                            <label class='rep-body-row-user'> <strong>Usuario:</strong> Esteban Carraza</label>
                                            <label class='rep-body-row-date-title'> <strong>Razon de bloqueo:</strong> </label>
                                            <select class='rep-body-row-date-razon'> 
                                                <option>Video no apropiado</option>
                                                <option>Odio los gatos</option>
                                                <option>Porque si >:v</option>
                                            </select>
                                        </article>
                                        <article class='rep-body-row-row'>
                                            <button class='rep-body-row-date-button' type='button'> Bloquear </button>
                                            <label class='rep-body-row-input'><input class='' type='text' placeholder='Escribe aqui un comentario para el usuario'/></label>
                                            <span class='rep-body-row-reporte'><strong>Reporte: </strong> Eso es muy ofensivo alv D:< </span>
                                        </article>
                                        <article class='rep-body-row-row'>
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
                                        </article>
                                    </span>
                                    -->
                                    <!--
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
                                    -->
                                </section>
                                
                                
                            </div>
                        </div>
                </section>
		<jsp:include page="footer.jsp" flush="true" />

	</body>
</html>