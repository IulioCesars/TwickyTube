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
    public static String getRespuesta()
    {
        return Respuesta;
    }
    public static String setRespuesta(String res)
    {
        Respuesta = res;
        return Respuesta;
    }
    public static class index
    {
        public static String fallo = "El correo o usuario están equivocados, o no existen";
        public static String correcto = "";
    }
    
    
}
