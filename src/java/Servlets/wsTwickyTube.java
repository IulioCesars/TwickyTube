/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ADO.AjaxADO;
import ADO.ComentarioADO;
import VO.Comentario;
import VO.Usuario;
import com.mysql.jdbc.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iuliocesar
 */
public class wsTwickyTube extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Action = request.getParameter("action");
        String Parametro = request.getParameter("p");
        Usuario usuario = (Usuario) request.getSession(true).getAttribute("usuario");
        String Resultado = "";
        if(usuario != null)
            switch(Action){
                case "Suscribirse" : { Resultado = AjaxADO.Suscribirse(Parametro, usuario.id_usuario); break;}
                case "MeGusta" : { Resultado = AjaxADO.MeGusta(usuario.id_usuario, Parametro);  break;}            
                case "Reportar" : {  break;}
                case "Favorito" : {  break;}
                case "Comentario": { 
                    String comentario = request.getParameter("comentario");
                    if(StringUtils.isEmptyOrWhitespaceOnly(comentario)){
                        Resultado = "Comentario en blanco";
                    }else{
                        Comentario com = ComentarioADO.CrearComentario(usuario.id_usuario, Parametro, comentario);
                        Resultado = com.toJSON();
                    }
                    
                    break;
                }
                default: { Resultado = "Error"; break; }
            }
        
        response.setContentType("text/plain;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.print(Resultado);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
