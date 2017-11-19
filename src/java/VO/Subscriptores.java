/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Helpers.Diccionario;
import Helpers.Util;
import java.sql.Timestamp;

/**
 *
 * @author esteban.carranza
 */
public class Subscriptores extends EntidadGenerica
{
    public static class BD_INDEX
    {
        public static String id_seguidor = "id_seguidor";
        public static String fk_perfil_remitente = "fk_perfil_remitente";
        public static String fk_perfil_destinatario = "fk_perfil_destinatario";
        public static String fecha = "fecha";
    }
    String id_seguidor;
    String fk_perfil_remitente;
    String fk_perfil_destinatario;
    Timestamp fecha;
    
    public Subscriptores()
    {
        
    }
    public Subscriptores(Diccionario dic)
    {
        this.id_seguidor = (String) super.ObtenerValor(dic.elementos.get(Subscriptores.BD_INDEX.id_seguidor));
        this.fk_perfil_remitente = (String) super.ObtenerValor(dic.elementos.get(Subscriptores.BD_INDEX.fk_perfil_remitente));
        this.fk_perfil_destinatario = (String) super.ObtenerValor(dic.elementos.get(Subscriptores.BD_INDEX.fk_perfil_destinatario));
        this.fecha = Util.convertStringToTimestamp(dic.elementos.get(Subscriptores.BD_INDEX.fecha).toString());
    }
    
    public String mostrar_subscriptores()
    {
        return "";
    }
}
