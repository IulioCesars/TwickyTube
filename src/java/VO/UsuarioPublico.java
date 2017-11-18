/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Helpers.Diccionario;
import Helpers.Util;
import java.sql.Timestamp;
import javax.servlet.http.Part;

/**
 *
 * @author esteban.carranza
 */
public class UsuarioPublico extends EntidadGenerica
{
    public static class BD_INDEX
    {
        public static String id_usuario = "id_usuario";
        public static String correo = "correo";
        public static String fecha_nacimiento = "fecha_nacimiento";
        public static String genero = "genero";
        public static String ciudad = "ciudad";
        public static String pais = "pais";
        public static String avatar = "avatar";
        public static String portada = "portada";
        public static String formato_avatar = "formato_avatar";
        public static String formato_portada = "formato_portada";
    }
    
        public String id_usuario;
        public String correo;
        public Timestamp fecha_nacimiento;
        public String genero;
        public String ciudad;
        public String pais;

        
        public UsuarioPublico(Diccionario usr)
        {
            this.id_usuario = (String) super.ObtenerValor(usr.elementos.get(UsuarioPublico.BD_INDEX.id_usuario));
            this.correo = (String) super.ObtenerValor(usr.elementos.get(UsuarioPublico.BD_INDEX.correo));
            this.fecha_nacimiento = Util.convertStringToTimestamp(usr.elementos.get(UsuarioPublico.BD_INDEX.fecha_nacimiento).toString());
            this.genero = (String) super.ObtenerValor(usr.elementos.get(UsuarioPublico.BD_INDEX.genero));
            this.ciudad = (String) super.ObtenerValor(usr.elementos.get(UsuarioPublico.BD_INDEX.ciudad));
            this.pais = (String) super.ObtenerValor(usr.elementos.get(UsuarioPublico.BD_INDEX.pais));
            
        }
        
        
}
