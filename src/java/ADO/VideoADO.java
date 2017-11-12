
package ADO;

import Helpers.Diccionario;
import Helpers.Pool;
import VO.Video;
import com.mysql.jdbc.StringUtils;
import java.util.List;

public class VideoADO 
{
    public static String subir_video(Video video)
    {
        String resultado;
        resultado = (String) Pool.EjecutarStoredProcedureSimple("sp_publicar", 
        /*List<Diccionario> dicResult;
        Pool.EjecutarStoredProcedure*/
        /*(   
            "sp_publicar", */
            new Object[] 
            { 
                video.titulo,
                video.descripcion,
                video.clasificacion,
                video.pathVideo,
                video.contentTypeVideo,
                video.pathVistaPrevia,
                video.contentTypeVistaPrevia,
                video.fk_usuario
             }
                
        );
        
        return resultado;
        /*
        List<Diccionario> dicResult;
        // Resultados
        // 0 = OK | 1 = Error Usuario | 2 = Error Correo
        dicResult = (String) Pool.EjecutarStoredProcedure
        (   
            "sp_publicar", 
            new Object[] 
            { 
                video.titulo,
                video.clasificacion,
                video.clasificacion,
                video.pathVideo,
                video.contentTypeVideo,
                video.pathVistaPrevia,
                video.contentTypeVistaPrevia,
                video.fk_usuario
             }
        );*/
        /*return "";*/
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
    public static Video Obtener(int id){
        List<Diccionario> dicVideo = Pool.EjecutarStoredProcedure("ObtenerVideo",new Object[] { id  });
        Video video = null;
        if(dicVideo.size() > 0){
            video = new Video(dicVideo.get(0));
        }
        return video;
    }
    
    public static boolean Validar(Video video){
        return video.id_video != -1
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

