/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.ExpedientesMedicos;
import main.ExpedientesMedicosAPI;
import models.Usuario;

/**
 *
 * @author P
 */
@WebServlet("/auth")
public class ServletAuth extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("index.html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Usuario user = api.identificarse(username, password);
        Cookie rolCk;
        Cookie idCk = new Cookie("id",user.getIdentificador());
        if(user.getRol() < 1){
            rolCk = new Cookie("rol","Paciente");
        }else{
            rolCk = new Cookie("rol","Doctor");
        }
        
        if (user != null) {
            rd = request.getRequestDispatcher("principal.html");
        } else {
            rd = request.getRequestDispatcher("index.html");
        }
        response.addCookie(idCk);
        response.addCookie(rolCk);
        rd.forward(request, response);
    }

}
