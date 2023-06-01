package servlets;

import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletUsuarioPedir", urlPatterns = {"/ServletUsuarioPedir"})
public class ServletUsuarioPedir extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                UsuarioController usuarioController = new UsuarioController();
                String user = request.getParameter("username");
                String result = usuarioController.pedir(user);

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
    }// </editor-fold>

}
