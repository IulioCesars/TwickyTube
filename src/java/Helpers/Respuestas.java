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
    
    
}
