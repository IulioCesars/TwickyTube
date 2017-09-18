/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author IulioCesar
 */
public class EntidadGenerica {
    public Object ObtenerValor(Object obj){
        
        if(obj == "NULL")
            return null;
        
        return obj;
    }
}
