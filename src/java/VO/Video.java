
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
 * @author esteban.carranza
 */
public class Video extends EntidadGenerica
{
    public int id_video;
    public Timestamp fecha;
    public String titulo;
    public String descripcion;
    public String clasificacion;
    public String pathVideo;
    public String pathVistaPrevia;
    public String fk_usuario;
    public String contentTypeVideo;
    public String contentTypeVistaPrevia;
    
    public Video()
    {
    
    }
    public Video(Diccionario vid){
        this.id_video = (int) super.ObtenerValor(vid.elementos.get("id_video"));
        this.fecha = Util.convertStringToTimestamp(vid.elementos.get("fecha").toString());
        this.titulo = (String) super.ObtenerValor(vid.elementos.get("titulo"));
        this.descripcion = (String) super.ObtenerValor(vid.elementos.get("descripcion"));
        this.clasificacion = (String) super.ObtenerValor(vid.elementos.get("clasificacion"));
        this.pathVideo = (String) super.ObtenerValor(vid.elementos.get("pathVideo"));
        this.pathVistaPrevia = (String) super.ObtenerValor(vid.elementos.get("pathVistaPrevia"));
        this.fk_usuario = (String) super.ObtenerValor(vid.elementos.get("fk_usuario"));
        this.contentTypeVideo = (String) super.ObtenerValor(vid.elementos.get("contentTypeVideo"));
        this.contentTypeVideo = (String) super.ObtenerValor(vid.elementos.get("contentTypeVistaPrevia"));
    }
}
