/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import VO.Reporte;

/**
 *
 * @author esteban.carranza
 */
public class Respuestas {
    
    private static String Respuesta = "";
    private static String RespuestaSubirVideo = "";
    private static String RespuestaAdminReportar = "";
    private static String RespuestaReportarUsuario = "";
    private static String clasesEtiqueta = "idx-login-gen-label";
    private String idUsuarioX = "";
    
    public static String getRespuesta()
    {
        return Respuesta;
    }
    public static String setRespuesta(String res, String alerta)
    {
        Respuesta = "<label" + clasesEtiqueta + " "+ alerta + ">" + res + "</label>";
        return Respuesta;
    }
    public static String getRespuestaSubirVideo()    
    {
        return RespuestaSubirVideo;
    }
    public static String setRespuestaSubirVideo(String respuesta)
    {
        RespuestaSubirVideo = respuesta;
        return RespuestaSubirVideo;
    }
    
    public static String getRespuestaAdminReportar()
    {
        return RespuestaAdminReportar;
    }
    public static String setRespuestaAdminReportar(String respuesta)
    {
        RespuestaAdminReportar = respuesta;
        return RespuestaAdminReportar;
    }
    public static String getRespuestaReportarUsuario()
    {
        return RespuestaReportarUsuario;
    }
    public static String setRespuestaReportarUsuario(String respuesta)
    {
        RespuestaReportarUsuario = respuesta;
        return RespuestaReportarUsuario;
    }
    
    
    public static class reportar_usuario
    {
        public static String id_usuario = "";
        public static String setIdUsuario(String idUsuario)
        {
            id_usuario = idUsuario;
            return id_usuario;
        }
        
        public static String Reportando = "" +
                 "<div id='RespuestaVideo' name='finish-upload' class='upl-finish-upload' style='display:none'>" +
                    "<label class='upl-finish-upload-label shadow-center-1004'>" +
                        "<form method='get' action='ReportarUsuario'>" +
                            "¿Porqué "+id_usuario+"quieres reportarlo?"+
                            "<input name='"+Reporte.BD_INDEX.fk_usuario+"' type='hidden' value='"+ id_usuario+"'>" +
                            "<br><input name='"+Reporte.BD_INDEX.comentarioReporte+"' class='glob-object-input' type='text' placeholder='Comentario'>" +
                            "<br><input class='glob-object-submit' type='submit' value='Enviar reporte'>" +
                            "<input class='glob-object-submit' type='button' onclick='cerrar_mensaje()' value='Cerrar'>" +
                        "</form>" +
                    "</label>" +
                "</div>";
        public static String Reportado = "" +
                 "<div id='RespuestaVideo' name='finish-upload' class='upl-finish-upload' onclick='ocultar_subirVideo()'>" +
                    "<label class='upl-finish-upload-label shadow-center-1004 "+ estado_alerta.Correcto +"'>" +
                        "Ups!, algo salió mal :(, ¿quieres que lo volvamos a intentar?" +
                    "</label>" +
                "</div>";
    }
    
    public static class estado_alerta
    {
        public static String Correcto = "glob-alert-correct";
        public static String Error = "glob-alert-error";
    }
        
    public static class index
    {
        public static String fallo = "El correo o usuario están equivocados, o no existen";
        public static String correcto = "";
    }
    public static class registro
    {
        public static String correcto =  "El registro fue exitoso, inicia sesión para continuar";
        public static String fallo =     "Algo salió mal, intentalo de nuevo";
        public static String duplicados =  "El alias o el correo están duplicados";
        
    }
    public static class AdminReportar
    {
        public static String correcto = 
                "<div id='RespuestaVideo' name='finish-upload' class='upl-finish-upload' onclick='ocultar_subirVideo()'>" +
                    "<label class='upl-finish-upload-label shadow-center-1004 "+ estado_alerta.Correcto +"'>" +
                        "Se bloqueó el contenido" +
                    "</label>" +
                "</div>";
        public static String fallo = 
                "<div id='RespuestaVideo' name='finish-upload' class='upl-finish-upload' onclick='ocultar_subirVideo()'>" +
                    "<label class='upl-finish-upload-label shadow-center-1004 "+ estado_alerta.Error +"'>" +
                        "Ups!, algo salió mal :(, ¿quieres que lo volvamos a intentar?" +
                    "</label>" +
                "</div>";
    }
    public static class subida_video
    {
        public static String correcto = 
                "<div id='RespuestaVideo' name='finish-upload' class='upl-finish-upload' onclick='ocultar_subirVideo()'>" +
                    "<label class='upl-finish-upload-label shadow-center-1004 "+ estado_alerta.Correcto +"'>" +
                        "Tu video se subió exitosamente!" +
                    "</label>" +
                "</div>";
        public static String fallo = 
                "<div id='RespuestaVideo' name='finish-upload' class='upl-finish-upload' onclick='ocultar_subirVideo()'>" +
                    "<label class='upl-finish-upload-label shadow-center-1004 "+ estado_alerta.Error +"'>" +
                        "Ups!, algo salió mal :(, ¿quieres que lo volvamos a intentar?" +
                    "</label>" +
                "</div>";
        
    }

    
}
