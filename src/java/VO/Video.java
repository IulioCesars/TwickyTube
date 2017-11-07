/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.sql.Timestamp;

/**
 *
 * @author iuliocesar
 */
public class Video {
    public String id_video;
    public Timestamp fecha;
    public String fk_usuario;
    public String titulo;
    public String descripcion;
    public String clasificacion;
    public String pathVideo;
    public String pathVistaPrevia;
}
