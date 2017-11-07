/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO;

import VO.Video;
import com.mysql.jdbc.StringUtils;

/**
 *
 * @author iuliocesar
 */
public class VideoADO {
    public static boolean CrearVideo( Video video){
        return true;
    }
    
    public static boolean Validar(Video video){
        return !StringUtils.isNullOrEmpty(video.fk_usuario)
                && !StringUtils.isNullOrEmpty(video.titulo)
                && !StringUtils.isNullOrEmpty(video.descripcion)
                && !StringUtils.isNullOrEmpty(video.clasificacion)
                && !StringUtils.isNullOrEmpty(video.pathVideo)
                && !StringUtils.isNullOrEmpty(video.pathVistaPrevia);        
    }
}
