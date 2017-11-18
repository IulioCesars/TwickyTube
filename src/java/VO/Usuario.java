/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;
import Helpers.Diccionario;
import Helpers.Util;
import java.awt.Image;
import java.sql.Timestamp;
import javax.servlet.http.Part;
/**
 *
 * @author IulioCesar
 */
public class Usuario extends EntidadGenerica{
    public String id_usuario;
    public String correo;
    public String contraseña;
    public Timestamp fecha_nacimiento;
    public String genero;
    public String ciudad;
    public String pais;
    public Part partAvatar;
    public String formato_avatar;
    public Part partPortada;
    public String formato_portada;
    public String perfil;
    public String Mensaje = "";
    public Usuario(){
    
    }
    
    public Usuario (String mes)
    {
        String Mensaje = mes;
        
    }
    public Usuario(Diccionario usr){
        this.id_usuario = (String) super.ObtenerValor(usr.elementos.get("id_usuario"));
        this.correo = (String) super.ObtenerValor(usr.elementos.get("correo"));
        this.contraseña = (String) super.ObtenerValor(usr.elementos.get("contraseña"));
        this.fecha_nacimiento = Util.convertStringToTimestamp(usr.elementos.get("fecha_nacimiento").toString());
        this.genero = (String) super.ObtenerValor(usr.elementos.get("genero"));
        this.ciudad = (String) super.ObtenerValor(usr.elementos.get("ciudad"));
        this.pais = (String) super.ObtenerValor(usr.elementos.get("pais"));
        this.perfil = (String) super.ObtenerValor(usr.elementos.get("perfil"));
    }
    
    public String toHTML(){
        return "<span class='dbd-start-span'>\n" +
                    "<a href='canal.jsp?id=" + this.id_usuario  +"' class='dbd-start-video-label'>\n" +
                        "<img class='dbd-start-video-label-content' src='MostrarAvatar?id=" + this.id_usuario + "'/>\n" +
                        "<label class='dbd-start-video-label-title'> " + this.id_usuario + " </label>\n" +
                    "</a>\n" +
                "</span>";
    }
}
