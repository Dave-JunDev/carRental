package servlets;

import controller.CarrosController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ServletCarroListar"})
public class ServletCarroListar extends HttpServlet {


@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                CarrosController carroController = new CarrosController();
                boolean ordenar = Boolean.parseBoolean(request.getParameter("ordenar"));
                String orden = request.getParameter("orden");
                List<String> result = carroController.Listar(ordenar, orden);

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
