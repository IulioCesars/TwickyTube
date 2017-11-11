/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ADO.VideoADO;
import Helpers.Respuestas;
import Helpers.Rutas;
import static Helpers.Rutas.CarpetaParaSubirArchivos;
import Helpers.Util;
import VO.Video;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author esteban.carranza
 */
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
                 maxFileSize=1024*1024*50,          // 50 MB
                 maxRequestSize=1024*1024*100)      // 100 MB
public class Publicacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String subirArchivo(int codigo, HttpServletRequest request, HttpServletResponse response, String path_archivo, String nombre_usuario) 
            throws ServletException, IOException
    {
        Part filePart = request.getPart(path_archivo); // Obtiene el archivo
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String path= getServletContext().getRealPath("/") + CarpetaParaSubirArchivos + nombre_usuario ;
        
        File uploads = new File(path); //Carpeta donde se guardan los archivos
        uploads.mkdirs(); //Crea los directorios necesarios
        File file = File.createTempFile("cod"+codigo+"-", "-"+fileName, uploads); //Evita que hayan dos archivos con el mismo nombre

        try (InputStream input = filePart.getInputStream())
        {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

    return file.getPath();
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String pathVideo = subirArchivo(0,request, response, "path_vid_video", "esteban");
        String pathImagen = subirArchivo(0,request, response, "path_img_video", "esteban");      
        
        Video publicacion = new Video();
        
        publicacion.id_video = request.getParameter("id_video");
        publicacion.titulo = request.getParameter("titulo");
        publicacion.descripcion = request.getParameter("descripcion");
        publicacion.clasificacion = request.getParameter("clasificacion");
        publicacion.fecha = Util.convertStringToTimestamp(request.getParameter("fecha"));
        publicacion.pathVistaPrevia = pathImagen;
        publicacion.pathVideo = pathVideo;
        
        publicacion.contentTypeVideo = "video/mp4";
        publicacion.contentTypeVistaPrevia = "image/png";
        publicacion.fk_usuario = "1";
        
        String resultadoVideo = "";
        resultadoVideo = VideoADO.subir_video(publicacion);
        /*
        Part file_video = request.getPart("path_vid_video");
        String pathVideo = "web/temp/yolo.mp4";
        file_video.write(pathVideo);
        
        Part file_imagen = request.getPart("path_img_video");
        String pathImagen = "web/temp/yolo.png";
        file_imagen.write(pathImagen);
        */
          try (PrintWriter out = response.getWriter()) {
        
            Respuestas.setRespuestaSubirVideo(Respuestas.subida_video.correcto);
            request.getRequestDispatcher(Rutas.Upload).forward(request, response);
        
      //String respuesta = "";
      //respuesta = VideoADO.subir_video(publicacion);
     
            
            
          }
      /*
      if(respuesta == "OK")
      {
        Respuestas.setRespuesta(respuesta);
        response.sendRedirect(Rutas.Login);
      }
        else
      {
          Respuestas.setRespuesta(respuesta);
        response.sendRedirect(Rutas.Login);
      }
      */
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
