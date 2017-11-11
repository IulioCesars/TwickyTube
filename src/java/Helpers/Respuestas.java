/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author esteban.carranza
 */
public class Respuestas {
    
    private static String Respuesta = "";
    private static String RespuestaSubirVideo = "";
    private static String clasesEtiqueta = "idx-login-gen-label";
    
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
