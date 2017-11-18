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
public class Reporte extends EntidadGenerica
{
    public static class BD_INDEX
    {
        public static String id_bloqueo = "id_bloqueo";
        public static String fk_usuario = "fk_usuario";
        public static String fk_video = "fk_video";
        public static String fk_tipoPost = "fk_tipoPost";
        public static String fk_fechaReporte = "fk_fechaReporte";
        public static String indefinido = "indefinido";
        public static String fk_razonBloqueo = "fk_razonBloqueo";
        public static String descripcion = "descripcion";
        public static String comentarioReporte = "comentarioReporte";
        public static String comentarioBloqueo = "comentarioBloqueo";
        public static String pathVideo = "pathVideo";
        public static String fechaBloqueo = "fechaBloqueo";
        public static String descripcionTipoPost = "descripcionTipoPost";
        public static String descripcionRazonBloqueo = "descripcionRazonBloqueo";
        public static String fechaReporte = "fechaReporte";
    };
    public int id_bloqueo;
    public String fk_usuario;
    public int fk_video;
    public int fk_tipoPost;
    public Timestamp fechaReporte;
    public Boolean indefinido;
    public int fk_razonBloqueo;
    public String descripcion;
    public String comentarioReporte;
    public String comentarioBloqueo;
    public String pathVideo;
    public Timestamp fechaBloqueo;
    public String descripcionTipoPost;
    public String descripcionRazonBloqueo;
    
     public Reporte()
    {
    
    }
   
     
    public Reporte(Diccionario rep)
    {
        this.id_bloqueo = (int) super.ObtenerValor(rep.elementos.get(Reporte.BD_INDEX.id_bloqueo));
        this.fk_usuario = (String) super.ObtenerValor(rep.elementos.get(Reporte.BD_INDEX.fk_usuario));
        this.descripcion = (String) super.ObtenerValor(rep.elementos.get(Reporte.BD_INDEX.descripcion));
        this.comentarioReporte = (String) super.ObtenerValor(rep.elementos.get(Reporte.BD_INDEX.comentarioReporte));
        this.fk_video = (int) super.ObtenerValor(rep.elementos.get(Reporte.BD_INDEX.fk_video));
        this.pathVideo = (String) super.ObtenerValor(rep.elementos.get(Reporte.BD_INDEX.pathVideo));
        
    
    }
    
     public String Mostrar_lista_para_bloquear()
     {
        return  "<form action='AdminReportar'>" +
                    "<input name='"+Reporte.BD_INDEX.id_bloqueo+"' type='hidden' value='"+this.id_bloqueo+"'/>" +
                    "<span class='rep-body-row'>" +
                        "<img class='rep-body-row-image' src='MostrarAvatar?id="+this.fk_usuario+"'>" +

                        "<article class='rep-body-row-row'>" +
                            "<span class='rep-body-row-tipoPost'><strong>Tipo de post: </strong> "+this.descripcion +" </span>" +
                            "<section>" +
                                "<label class='rep-body-row-date-title'> <strong>Bloquear hasta:</strong> </label>" +
                                "<input name='"+Reporte.BD_INDEX.fechaBloqueo+"' required class='ipt-date rep-body-row-date' type='date' min='2017-11-18' value='2017-11-18' />" +
                                "<label class='rep-body-row-date-checkbox'><strong>Indefinido - </strong><input name='"+Reporte.BD_INDEX.indefinido+"' class='chk-indefinido' type=\"checkbox\" value='1' checked=\"checked\"/></label>" +
                            "</section>" +
                        "</article>" +
                        "<article class='rep-body-row-row'>" +
                            "<label class='rep-body-row-user'> <strong>Usuario:</strong> "+ this.fk_usuario +"</label>" +
                            "<label class='rep-body-row-date-title'> <strong>Razon de bloqueo:</strong> </label>" +
                            "<select name='"+Reporte.BD_INDEX.fk_razonBloqueo+"' class='rep-body-row-date-razon'> " +
                            "   <option value='1'>Marcado con clasificacion incorrecta </option>" +
                                "<option value='2'>Lenguaje no apropiado </option>" +
                                "<option value='3'>Demasiada sangre </option>" +
                                "<option value='4'>Contenido para adultos </option>" +
                            "</select>" +
                        "</article>" +
                        "<article class='rep-body-row-row'>" +

                            "<button class='rep-body-row-date-button' type='submit'> Bloquear </button>" +
                            "<label class='rep-body-row-input'><input name='"+Reporte.BD_INDEX.comentarioBloqueo+"' required class='' type='text' placeholder='Escribe aqui un comentario para el usuario'/></label>" +

                            "<span class='rep-body-row-reporte'><strong>Reporte: </strong> "+this.comentarioReporte+" </span>" +
                        "</article>" +
                        "<article class='rep-body-row-row'>" +
                            "<span class='rep-body-row-post'>" +
                            "    <strong class='rep-body-row-post-title'>Post: </strong> " +
                            "    <span  class='rep-body-row-post-body'> " +
                                    "<video src='"+this.pathVideo +"' controls> </video>" +
                            "    </span>" +
                            "</span>" +
                        "</article>" +
                    "</span>"+
                "</form>";

    }
     
    
     
}
