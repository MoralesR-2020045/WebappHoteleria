package com.techtitans.servlet;

import com.techtitans.model.MetodoDePago;
import com.techtitans.service.MetodoDePagoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Donovan Morales
 */
@WebServlet(name = "MetodoDePagoServlet", value = {"/metodoDePago-servlet"})
@MultipartConfig
public class MetodoDePagoServlet extends HttpServlet {

    private MetodoDePagoService metodoDePagoService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.metodoDePagoService = new MetodoDePagoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        List<MetodoDePago> metodos = metodoDePagoService.listaMetodoDePago();
        metodos.forEach(m -> System.out.println(m));
        
        request.setAttribute("metodos", metodos);
        request.getRequestDispatcher("/MetodoDePago-JSP/Lista-MetodoDePago.jsp").forward(request, responce);
    }

    private void agregarMetodoDePago(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        String nombre = request.getParameter("nombreDelMetodo");
        MetodoDePago metodo = new MetodoDePago(id, nombre);
        metodoDePagoService.agregarMetodoDePago(metodo);

        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            agregarMetodoDePago(request, response);

        } else {
            response.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }
    }

}
