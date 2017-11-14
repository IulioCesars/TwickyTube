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
public class EditarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = (Usuario) request.getSession(true).getAttribute("usuario");
        String respuesta = "";
        try{
            if(usuario != null){
                usuario.fecha_nacimiento = Util.convertStringToTimestamp(request.getParameter("fNacimiento"));
                usuario.genero = request.getParameter("genero").substring(0, 1);
                usuario.ciudad = request.getParameter("ciudad");
                usuario.pais = request.getParameter("pais");
                usuario.contraseña = request.getParameter("contrasenia");
                usuario.partAvatar = request.getPart("img-avatar");
                usuario.partPortada = request.getPart("img-portada");        


                respuesta = UsuarioADO.EditarUsuario(usuario);


            }
        }catch(Exception ex){
            respuesta = ex.getMessage();
        }
        
        if(respuesta == "OK"){
                response.sendRedirect(Rutas.Perfil);
            }
        else{
            response.sendRedirect(Rutas.PerfilError);
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
