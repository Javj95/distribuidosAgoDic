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
public class ServletRegister extends HttpServlet {

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
        String rol = request.getParameter("tipo_usuario");
        String id = request.getParameter("id");
        System.out.println(username + ", " + password + ", " + rol + ", " + id);
        Usuario user = new Usuario();

        user.setUsername(username);
        user.setPassword(password);
        user.setIdentificador(id);
        if (rol == "Paciente") {
            user.setRol(0);
        } else if (rol == "Doctor") {
            user.setRol(1);
        } else {
            rd = request.getRequestDispatcher("index.html");

        }

        if (api.registrarUsuario(user)) {
            rd = request.getRequestDispatcher("index.html");

        } else {
            rd = request.getRequestDispatcher("index.html");
        }
        rd.forward(request, response);
    }

}
