/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO;

import Helpers.Diccionario;
import Helpers.Pool;
import VO.Reporte;
import VO.ReporteBloqueado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban.carranza
 */
public class ReporteADO {


    public static String UsuarioReportaUsuario(String id, String comentarioReporte)
    {
        String resultado = "";
         resultado = (String) Pool.EjecutarStoredProcedureSimple
        (   
            "UsuarioReporta", 
            new Object[] { 
                            id,
                            comentarioReporte
                        });

      
        return resultado;
    }
    
    public static String reportar(Reporte rep)
    {
        String resultado = "";
      
        // Resultados
        // 0 = OK | 1 = Error Usuario | 2 = Error Correo
        resultado = (String) Pool.EjecutarStoredProcedureSimple
        (   
            "AdminReporta", 
            new Object[] { 
                            rep.id_bloqueo,
                            rep.fk_razonBloqueo,
                            rep.fechaBloqueo,
                            rep.comentarioBloqueo,
                            rep.indefinido
                        });

        // String query  = "call AdminReporta(1, 2, date_add(convert(now(), date), interval 10 day), 'no manches, te pasaste, corrige eso >:v', 0);";
      
     
        return resultado;
    }
    
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
    
       public static List<ReporteBloqueado> mostrar_bloqueados(String U_orden, int U_limite1, int U_limite2, String clasificacion)
    {
        
        List<ReporteBloqueado> resultado = new ArrayList<ReporteBloqueado>();
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure
        (
            "MostrarListaBloqueo", 
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
                        resultado.add( new ReporteBloqueado(d));
               // }
                //catch(Exception ex){
                
                //}
            }
        }
        
        return resultado;
    }
}
