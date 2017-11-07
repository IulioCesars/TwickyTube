
package ADO;

import Helpers.Pool;
import VO.Video;
import com.mysql.jdbc.StringUtils;

public class VideoADO 
{
    public static String subir_video(Video video)
    {
        String resultado = "";
        // Resultados
        // 0 = OK | 1 = Error Usuario | 2 = Error Correo
        resultado = (String) Pool.EjecutarStoredProcedureSimple
        (   
            "SubirVideo", 
            new Object[] 
            { 
                video.id_video ,
                video.titulo,
                video.descripcion,
                video.clasificacion,
                video.fecha
                    /*,
                video.path_img_video,
                video.path_vid_video*/
             }
        );
        return resultado;
    }
    public static String editar_video()
    {
        String resultado = "";
        
        return resultado;
    }
    public static String eliminar_video()
    {
        String resultado = "";
        
        return resultado;
    }
    public static String actualizar_video()
    {
        String resultado = "";
        
        return resultado;
    }
    public static boolean Validar(Video video){
        return !StringUtils.isNullOrEmpty(video.id_video)
                && !StringUtils.isNullOrEmpty(video.titulo)
                && !StringUtils.isNullOrEmpty(video.descripcion)
                && !StringUtils.isNullOrEmpty(video.clasificacion)
                && !StringUtils.isNullOrEmpty(video.pathVideo)
                && !StringUtils.isNullOrEmpty(video.pathVistaPrevia);        
    }
    public static void CrearVideo(Video video)
    {
        
    }
}

