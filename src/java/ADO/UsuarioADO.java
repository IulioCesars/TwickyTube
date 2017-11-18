/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO;
import Helpers.Pool;
import Helpers.Diccionario;
import VO.Usuario;
import VO.UsuarioPublico;
import VO.Video;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author IulioCesar
 */
public class UsuarioADO {
    public static Usuario IniciarSesion(String usuario, String contraseña){
        Usuario resultado = null;
        List<Diccionario> dicResult = Pool.EjecutarStoredProcedure("IniciarSesion", new Object[]{usuario, contraseña});
        if(dicResult.size()>0){
            resultado = new Usuario(dicResult.get(0));
        }
        return resultado;
    }
    
    public static String CrearUsuario(Usuario usuario) throws IOException{
        String resultado = "";
        // Resultados
        // 0 = OK | 1 = Error Usuario | 2 = Error Correo
        resultado = (String) Pool.EjecutarStoredProcedureSimple("CrearUsuario", 
                                new Object[] { usuario.id_usuario ,
                                               usuario.correo,
                                               usuario.contraseña,
                                               usuario.fecha_nacimiento.toString(),
                                               usuario.genero,
                                               usuario.ciudad,
                                               usuario.pais,
                                               usuario.partAvatar.getInputStream(),
                                               usuario.partPortada.getInputStream()
                                            });
        
        
        return resultado;
    }
    
    public static String EditarUsuario(Usuario usuario) throws IOException{
        String resultado = "";
        resultado = (String) Pool.EjecutarStoredProcedureSimple("EditarUsuario", 
                                new Object[] { usuario.id_usuario,
                                               usuario.contraseña,
                                               usuario.fecha_nacimiento.toString(),
                                               usuario.genero,
                                               usuario.ciudad,
                                               usuario.pais,
                                               usuario.partAvatar.getInputStream(),
                                               usuario.partPortada.getInputStream()
                                            });
        return resultado;
    }
    
    public static Usuario Obtener(String id_usuario){
        Usuario resultado =  null;
        List<Diccionario> dicResult = Pool.EjecutarStoredProcedure("ObtenerUsuario", new Object[]{ id_usuario });
        if(dicResult.size()>0){
            resultado = new Usuario(dicResult.get(0));
        }
        return resultado;
    }
    
    public static List<Usuario> Buscar(String Filtro){
        List<Usuario> resultado = new ArrayList<Usuario>();
        List<Diccionario> dicResul = Pool.EjecutarStoredProcedure("BuscarUsuario", new Object[]{ Filtro });
        if(dicResul.size()>0){
            for(Diccionario d : dicResul){
                try{
                    resultado.add( new Usuario(d));
                }
                catch(Exception ex){
                
                }
            }
        }
        return resultado;
    }
    
    public static Usuario ObtenerCanalFavorito(String id_usuario){
        Usuario resultado =  null;
        List<Diccionario> dicResult = Pool.EjecutarStoredProcedure("ObtenerCanalFavorito", new Object[]{ id_usuario });
        if(dicResult.size()>0){
            resultado = new Usuario(dicResult.get(0));
        }
        return resultado;
    }
    
        public static UsuarioPublico ObtenerInfo(int id)
        {
            UsuarioPublico resultado =  null;
            List<Diccionario> dicResult = Pool.EjecutarStoredProcedure
            (
                "ObtenerUsuario", 
                new Object[]
                { 
                    id
                });
            if(dicResult.size()>0){
                resultado = new UsuarioPublico(dicResult.get(0));
            }
            return resultado;
        }
}
