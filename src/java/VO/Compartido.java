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
 * @author IulioCesar
 */
public class Compartido extends EntidadGenerica {
    public int id_compartido;
    public int fk_video;
    public String fk_usuario;
    public Timestamp fecha;
    
    public Compartido(){}
    
    public Compartido(Diccionario c){
        this.id_compartido = (int) super.ObtenerValor(c.elementos.get(""));
        this.fk_video = (int) super.ObtenerValor(c.elementos.get(""));
        this.fk_usuario = (String) super.ObtenerValor(c.elementos.get(""));
        this.fecha = Util.convertStringToTimestamp(super.ObtenerValor(c.elementos.get("")).toString());
    }
}
