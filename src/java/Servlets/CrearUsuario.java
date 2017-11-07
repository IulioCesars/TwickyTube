/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ADO.UsuarioADO;
import Helpers.Respuestas;
import Helpers.Rutas;
import Helpers.Util;
import VO.Usuario;
import com.mysql.jdbc.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.lang.Object;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.IOUtils;

@MultipartConfig
public class CrearUsuario extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Usuario usuario = new Usuario();
        
        usuario.id_usuario = request.getParameter("alias");
        usuario.correo = request.getParameter("correo");
        usuario.contraseña = request.getParameter("contrasenia");
        usuario.fecha_nacimiento = Util.convertStringToTimestamp(request.getParameter("fechaNacimiento"));
        usuario.genero = request.getParameter("genero").substring(0, 1);
        usuario.ciudad = request.getParameter("ciudad");
        usuario.pais = request.getParameter("pais");
        
        usuario.partAvatar = request.getPart("img-avatar");
        usuario.partPortada = request.getPart("img-portada");
        
        String respuesta = UsuarioADO.CrearUsuario(usuario);
        if(respuesta == null)
        {
            respuesta = "ERROR 00";
        }
        
        switch(respuesta)
        {
            case "OK":
            Respuestas.setRespuesta(Respuestas.registro.correcto, Respuestas.estado_alerta.Correcto);
            response.sendRedirect(Rutas.Login);
            break;
            
             case "ERROR 00":
                Respuestas.setRespuesta(Respuestas.registro.fallo, Respuestas.estado_alerta.Error);
                response.sendRedirect(Rutas.CrearUsuarioFallido);
            break;
            
            case "ERROR 01":
                Respuestas.setRespuesta(Respuestas.registro.fallo, Respuestas.estado_alerta.Error);
                response.sendRedirect(Rutas.CrearUsuarioFallido);
            break;
                
            case "ERROR 02":
                Respuestas.setRespuesta(Respuestas.registro.duplicados, Respuestas.estado_alerta.Error);
                response.sendRedirect(Rutas.CrearUsuarioFallido);
            break;
            default:
                //response.sendRedirect(Rutas.Login);
            break;
        }
        
        
        
            
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
