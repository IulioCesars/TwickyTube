/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;
import Helpers.Diccionario;
import java.awt.Image;
import java.sql.Timestamp;
/**
 *
 * @author IulioCesar
 */
public class Usuario extends EntidadGenerica{
    public String id_usuario;
    public String email;
    public String contraseña;
    public Timestamp fecha_nacimiento;
    public String genero;
    public Image avatar;
    public Image portada;
    public String perfil;
    
    public Usuario(){
    
    }
    
    public Usuario(Diccionario usr){
        this.id_usuario = (String) super.ObtenerValor(usr.elementos.get("id_usuario"));
        this.email = (String) super.ObtenerValor(usr.elementos.get("email"));
        this.contraseña = (String) super.ObtenerValor(usr.elementos.get("contraseña"));
        this.fecha_nacimiento = (Timestamp) super.ObtenerValor(usr.elementos.get("fecha_nacimiento"));
        this.genero = (String) super.ObtenerValor(usr.elementos.get("genero"));
        this.avatar = (Image) super.ObtenerValor(usr.elementos.get("avatar"));
        this.portada = (Image) super.ObtenerValor(usr.elementos.get("portada"));
        this.perfil = (String) super.ObtenerValor(usr.elementos.get("perfil"));
    }
}
