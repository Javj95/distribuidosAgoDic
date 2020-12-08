/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.ExpedientesMedicos;
import main.ExpedientesMedicosAPI;
import models.Expediente;
import models.Usuario;

/**
 *
 * @author P
 */
public class ServletExpediente extends HttpServlet {

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
        Gson gson = new Gson();
        ExpedientesMedicosAPI api = new ExpedientesMedicos();
        String curp = request.getParameter("curp");
        Expediente expediente = api.consultarExpediente(curp);
        if (expediente != null) {
            
            PrintWriter pw = response.getWriter();
            String json = gson.toJson(expediente);
            pw.print(json);
            pw.flush();
            response.setStatus(200);
        }else{
            response.setStatus(400);
        }
        

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
        ExpedientesMedicosAPI api = new ExpedientesMedicos();
        Expediente exp = new Expediente();    

        exp.setCurp(request.getParameter("curp"));
        exp.setNombre(request.getParameter("nombre"));
        exp.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        exp.setDomicilio(request.getParameter("domicilio"));
        exp.setSexo(request.getParameter("sexo"));
        exp.setFechaNacimiento(formatDate(request.getParameter("fechaNacimiento")));
        exp.setEdad(request.getParameter("edad"));
        
        if(api.registrarExpediente(exp)){
            response.setStatus(200);
        }else{
            response.setStatus(400);
        }
                
    }
    
    public String formatDate(String date){
        String result = "";
        result.concat(date.substring(5, 6)+"."+date.substring(8, 9));
        return result;
    }
}
