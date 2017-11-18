/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO;

import Helpers.Diccionario;
import Helpers.Pool;
import VO.Compartido;
import VO.Video;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IulioCesar
 */
public class CompartidoADO {
    public static String Compartir(int pVideo, String pUsuario){
        String resultado = (String) Pool.EjecutarStoredProcedureSimple("CompartirVideo", 
                                new Object[] { pVideo, pUsuario });
        if(resultado == "OK")
            return "Video Compartido";
        else
            return "Error al compartir, intente mas tarde";
    }
    
    public static List<Compartido> ObtenerVideosCompartidos(){
        List<Compartido> resultado = new ArrayList<Compartido>();
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure("ObtenerVideosCompartidos");
        if(dicResul.size()>0){
            for(Diccionario c : dicResul){
                try{
                    resultado.add( new Compartido(c));
                }
                catch(Exception ex){
                
                }
            }
        }
        
        return resultado;
    }
    
    public static List<Video> ObtenerVideosCompartidosPorUsuario(String id_usuario){
        List<Video> resultado = new ArrayList<Video>();
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure("ObtenerVideosCompartidosPorUsuario", new Object[]{ id_usuario });
        if(dicResul.size()>0){
            for(Diccionario c : dicResul){
                try{
                    resultado.add( new Video(c));
                }
                catch(Exception ex){
                
                }
            }
        }
        
        return resultado;
    }
}
