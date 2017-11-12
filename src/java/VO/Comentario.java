/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Helpers.Diccionario;
import Helpers.Util;
import java.sql.Timestamp;

/**
 *
 * @author iuliocesar
 */
public class Comentario extends EntidadGenerica{
    public int id_comentario;
    public String fk_usuario;
    public int fk_video;
    public String comentario;
    public Timestamp fecha;
    
    public Comentario(){
    
    }
    
    public Comentario(Diccionario usr){
        this.id_comentario = (int) super.ObtenerValor(usr.elementos.get("id_comentario"));
        this.fk_usuario = (String) super.ObtenerValor(usr.elementos.get("fk_usuario"));
        this.fk_video = (int) super.ObtenerValor(usr.elementos.get("fk_video"));
        this.comentario = (String) super.ObtenerValor(usr.elementos.get("comentario"));
        this.fecha = Util.convertStringToTimestamp(usr.elementos.get("fecha").toString());
    }
    
    public String toJSON(){
        return "{ 'fk_usuario':'" + this.fk_usuario + "', 'fk_video':" + this.fk_video + ", 'comentario':'" + this.comentario + "' }";
    }

}
