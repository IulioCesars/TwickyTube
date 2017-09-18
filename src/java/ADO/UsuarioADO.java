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
}
