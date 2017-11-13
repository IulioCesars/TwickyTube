/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO;

import Helpers.Diccionario;
import Helpers.Pool;
import Helpers.Util;
import java.util.List;

/**
 *
 * @author iuliocesar
 */
public class AjaxADO {
    //MeGustaCanal
    public static String Suscribirse(String id_usuarioCanal, String id_usaurio){
        String resultado = "";
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure("SeguirCanal", new Object[]{ id_usuarioCanal, id_usaurio});
        if(dicResul.size()>0){
            resultado = dicResul.get(0).elementos.get("Resultado").toString();
        }else{
            resultado = "Error";
        }
        return resultado;
    }
    
    public static String MeGusta(String id_usaurio, String id_video){
        String resultado = "";
        Integer idVideo = Util.StringTryParsetoInt(id_video);
        if(idVideo == null){ return "Error"; }
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure("MeGustaVideo", new Object[]{ id_usaurio, idVideo});
        if(dicResul.size()>0){
            resultado = dicResul.get(0).elementos.get("Resultado").toString();
        }else{
            resultado = "Error";
        }
        return resultado;
    }
    
    public static String Favorito(String id_usaurio, String id_video){
        String resultado = "";
        Integer idVideo = Util.StringTryParsetoInt(id_video);
        if(idVideo == null){ return "Error"; }
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure("MarcarFavorito", new Object[]{ id_usaurio, idVideo});
        if(dicResul.size()>0){
            resultado = dicResul.get(0).elementos.get("Resultado").toString();
        }else{
            resultado = "Error";
        }
        return resultado;
    }
}
