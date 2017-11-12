/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO;

import Helpers.Diccionario;
import Helpers.Pool;
import Helpers.Util;
import VO.Comentario;
import java.util.List;

/**
 *
 * @author iuliocesar
 */
public class ComentarioADO {
    public static Comentario CrearComentario(String usuario, String video, String comentario){
        Comentario resultado = null;
        Integer idVideo = Util.StringTryParsetoInt(video);
        if(idVideo == null){ return null; }
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure("CrearComentario", new Object[]{ usuario, video, comentario });
        if(dicResul.size()>0){
            resultado = new Comentario();
            resultado.fk_usuario = usuario;
            resultado.fk_video = idVideo;
            resultado.comentario = comentario;
        }
        return resultado;
    }
}
