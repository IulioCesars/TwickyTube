/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Helpers.Diccionario;
import Helpers.Util;

/**
 *
 * @author esteban.carranza
 */
public class Reporte extends EntidadGenerica
{
    public String fk_usuario;
    public String descripcion;
    public String comentarioReporte;
    public int fk_video;
    public String pathVideo;
   
     public Reporte()
    {
    
    }
    public Reporte(Diccionario rep)
    {
        this.fk_usuario = (String) super.ObtenerValor(rep.elementos.get("fk_usuario"));
        this.descripcion = (String) super.ObtenerValor(rep.elementos.get("descripcion"));
        this.comentarioReporte = (String) super.ObtenerValor(rep.elementos.get("comentarioReporte"));
        this.fk_video = (int) super.ObtenerValor(rep.elementos.get("fk_video"));
        this.pathVideo = (String) super.ObtenerValor(rep.elementos.get("pathVideo"));
    
    }
     public String ImprimeRegistrotoHTML()
     {
        return  "<span class='rep-body-row'>" +
                    "<img class='rep-body-row-image' src='MostrarAvatar?id="+this.fk_usuario+"'>" +
                    "<article class='rep-body-row-row'>" +
                        "<span class='rep-body-row-tipoPost'><strong>Tipo de post: </strong> "+this.descripcion +" </span>" +
                        "<section>" +
                            "<label class='rep-body-row-date-title'> <strong>Bloquear hasta:</strong> </label>" +
                            "<input class='ipt-date rep-body-row-date' type=\"date\" />" +
                            "<label class='rep-body-row-date-checkbox'><strong>Indefinido - </strong><input class='chk-indefinido' type=\"checkbox\" checked=\"checked\"/></label>" +
                        "</section>" +
                    "</article>" +
                    "<article class='rep-body-row-row'>" +
                        "<label class='rep-body-row-user'> <strong>Usuario:</strong> "+ this.fk_usuario +"</label>" +
                        "<label class='rep-body-row-date-title'> <strong>Razon de bloqueo:</strong> </label>" +
                        "<select class='rep-body-row-date-razon'> " +
                        "   <option value='1'>Marcado con clasificacion incorrecta </option>" +
                            "<option value='2'>Lenguaje no apropiado </option>" +
                            "<option value='3'>Demasiada sangre </option>" +
                            "<option value='4'>Contenido para adultos </option>" +
                        "</select>" +
                    "</article>" +
                    "<article class='rep-body-row-row'>" +
                        "<button class='rep-body-row-date-button' type='button'> Bloquear </button>" +
                        "<label class='rep-body-row-input'><input class='' type='text' placeholder='Escribe aqui un comentario para el usuario'/></label>" +
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
                "</span>";

    }
}
