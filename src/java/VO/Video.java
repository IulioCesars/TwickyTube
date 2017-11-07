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
    public String id_video;
    public Timestamp fecha;
    public String titulo;
    public String descripcion;
    public String clasificacion;
    public String path_vid_video;
    public String path_img_video;
    
    public Video()
    {
    
    }
    public Video(Diccionario vid){
        this.id_video = (String) super.ObtenerValor(vid.elementos.get("id_video"));
        this.fecha = Util.convertStringToTimestamp(vid.elementos.get("fecha").toString());
        this.titulo = (String) super.ObtenerValor(vid.elementos.get("titulo"));
        this.descripcion = (String) super.ObtenerValor(vid.elementos.get("descripcion"));
        this.clasificacion = (String) super.ObtenerValor(vid.elementos.get("clasificacion"));
        this.path_vid_video = (String) super.ObtenerValor(vid.elementos.get("path_vid_video"));
        this.path_img_video = (String) super.ObtenerValor(vid.elementos.get("path_vid_video"));
        
    }
}
