/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ADO.ReporteADO;
import Helpers.Respuestas;
import Helpers.Rutas;
import Helpers.Util;
import VO.Reporte;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban.carranza
 */
public class AdminReportar extends HttpServlet {

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
        
        
        
        
        Reporte rep = new Reporte();
        
        rep.id_bloqueo = Integer.parseInt(request.getParameter(Reporte.BD_INDEX.id_bloqueo));
        rep.fk_razonBloqueo = Integer.parseInt(request.getParameter(Reporte.BD_INDEX.fk_razonBloqueo));
        rep.fechaBloqueo = Util.convertStringToTimestamp(request.getParameter(Reporte.BD_INDEX.fechaBloqueo));
        rep.indefinido = Boolean.parseBoolean(request.getParameter(Reporte.BD_INDEX.indefinido));
        rep.comentarioBloqueo = request.getParameter(Reporte.BD_INDEX.comentarioBloqueo);
        
        String resultado = ReporteADO.reportar(rep);
        
        if(resultado == "OK")
        {
            Respuestas.setRespuestaAdminReportar(Respuestas.AdminReportar.correcto);
            request.getRequestDispatcher(Rutas.Reportes).forward(request, response);
        }
        else
        {
            Respuestas.setRespuestaAdminReportar(Respuestas.AdminReportar.fallo);
            request.getRequestDispatcher(Rutas.Reportes).forward(request, response);
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
