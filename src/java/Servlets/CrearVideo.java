package Servlets;

import ADO.VideoADO;
import VO.Usuario;
import VO.Video;
import com.mysql.jdbc.StringUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class CrearVideo extends HttpServlet {

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
        Video video = new Video();        

        if(usuario != null){        
            video.fk_usuario = usuario.id_usuario;
            video.titulo = request.getParameter("txtTitulo");
            video.descripcion = request.getParameter("txtDescripcion");        
            Part partVideo = request.getPart("fileVideo");
            if(partVideo != null){
                String path = new File(".").getAbsolutePath();
                String nombre = String.format("%s_%s_%s",
                                            video.fk_usuario, 
                                            partVideo.getSubmittedFileName(), 
                                            new SimpleDateFormat("ddMMMyyyy").format(new Date()));
                
                FileOutputStream fos = new FileOutputStream(path + File.separatorChar + nombre);
                //fos.write(partVideo.getInputStream());
                fos.close();
                
            }
            Part partVistaPrevia = request.getPart("fileVistaPrevia");
            
            
            if(VideoADO.Validar(video)){
                VideoADO.CrearVideo(video);
            }
            else{
                response.sendRedirect("");
            }
            
        }else{
            response.sendRedirect("");
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
