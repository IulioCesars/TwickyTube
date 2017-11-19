/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO;

import Helpers.Diccionario;
import Helpers.Pool;
import VO.Reporte;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban.carranza
 */
public class SubscriptoresADO 
{
    public static List<Reporte> mostrar_reportes(String U_orden, int U_limite1, int U_limite2, String clasificacion)
    {
        
        List<Reporte> resultado = new ArrayList<Reporte>();
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure
        (
            "UsuariosyVideosReportados", 
            new Object[]
            { 
                U_orden,
                U_limite1,
                U_limite2,
                clasificacion
                });
        if(dicResul.size()>0){
            for(Diccionario d : dicResul){
               // try{
                        resultado.add( new Reporte(d));
               // }
                //catch(Exception ex){
                
                //}
            }
        }
        
        return resultado;
    }
    
}
