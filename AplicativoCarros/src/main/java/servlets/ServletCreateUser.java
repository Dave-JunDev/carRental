/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "ServletCreateUser", urlPatterns = {"/ServletCreateUser"})
public class ServletCreateUser extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                UsuarioController usuarioController = new UsuarioController();
                String name = request.getParameter("name");
                String pass = request.getParameter("password");
                String email = request.getParameter("email");
                String username = request.getParameter("user");
                String lastName = request.getParameter("lastname1");
                String middleName = request.getParameter("lastname2");
                String result = usuarioController.Create(username, pass, name, email, lastName, middleName);

                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(result);
                out.flush();
                out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// 

}
