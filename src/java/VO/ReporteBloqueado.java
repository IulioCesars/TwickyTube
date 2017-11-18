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
public class ReporteBloqueado extends EntidadGenerica
{
     public static class BD_INDEX
    {
        public static String id_bloqueo = "id_bloqueo";
        public static String fk_usuario = "fk_usuario";
        public static String pathVideo = "pathVideo";
        public static String descripcionTipoPost = "descripcionTipoPost";
        public static String descripcionRazonBloqueo = "descripcionRazonBloqueo";
        public static String fechaReporte = "fechaReporte";
        public static String fechaBloqueo = "fechaBloqueo";
        public static String indefinido = "indefinido";
        public static String comentarioReporte = "comentarioReporte";
        public static String comentarioBloqueo = "comentarioBloqueo";

    };
     
        public int id_bloqueo;
        public String fk_usuario;
        public String pathVideo;
        public String descripcionTipoPost;
        public String descripcionRazonBloqueo;
        public Timestamp fechaReporte;
        public Timestamp fechaBloqueo;
        public String indefinido;
        public String comentarioReporte;
        public String comentarioBloqueo;
        
        
        
        
    
        public ReporteBloqueado()    
        {
            
        }
    
    public ReporteBloqueado(Diccionario rep)
    {
        
        this.id_bloqueo = (int) super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.id_bloqueo));
        this.fk_usuario = (String) super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.fk_usuario));
        this.pathVideo = (String) super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.pathVideo));
        this.descripcionTipoPost = (String) super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.descripcionTipoPost));
        this.descripcionRazonBloqueo = (String) super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.descripcionRazonBloqueo));
        this.fechaReporte = Util.convertStringToTimestamp(super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.fechaReporte)).toString());
        this.fechaBloqueo = Util.convertStringToTimestamp(super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.fechaBloqueo)).toString());
        this.indefinido = (String) super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.indefinido));
        this.comentarioReporte = (String) super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.comentarioReporte));
        this.comentarioBloqueo = (String) super.ObtenerValor(rep.elementos.get(ReporteBloqueado.BD_INDEX.comentarioBloqueo));
        
    }
    
     public String Mostrar_lista_de_bloqueados()
     {
        return  "" +
                "<span class='rep-body-row'>" +
                    "    <img class='rep-body-row-image' src='MostrarAvatar?id="+this.fk_usuario+"'>" +
                    "    <span class='rep-body-row-tipoPost bs-floatL-block-100'><strong>Razon de bloqueo: </strong> "+this.descripcionRazonBloqueo+ " </span>" +
                    "    <span class='rep-body-row-tipoPost bs-floatL-block-100'><strong>Bloqueado hasta: </strong> "+this.fechaBloqueo+ " </span>" +
                    "    <span class='rep-body-row-tipoPost bs-floatL-block-100'><strong>Usuario: </strong> "+this.fk_usuario+ " </span>" +
                    "    <span class='rep-body-row-tipoPost bs-floatL-block-100'><strong>Comentario: </strong> "+this.comentarioBloqueo+ " </span>" +
                    
                    
                    "    <span class='rep-body-row-post'>" +
                    "        <strong class='rep-body-row-post-title'>Post: </strong> " +
                    "        <span  class='rep-body-row-post-body'> " +
                    "            <video src='"+this.pathVideo+"' controls></video>" +
                    "        </span>" +
                    "    </span>" +
                "</span>"+  
                "";

    }
}
