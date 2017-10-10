/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO;
import Helpers.Pool;
import Helpers.Diccionario;
import VO.Usuario;
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
    
    public static String CrearUsuario(Usuario usuario){
        String resultado = "";
        
        // Resultados
        // 0 = OK | 1 = Error Usuario | 2 = Error Correo
        resultado = (String) Pool.EjecutarStoredProcedureSimple("CrearUsuario", 
                                new Object[] { usuario.id_usuario ,
                                               usuario.correo,
                                               usuario.contraseña,
                                               null,
                                               usuario.genero,
                                               null,
                                               null
                                            });
        
        
        return resultado;
    }
}
