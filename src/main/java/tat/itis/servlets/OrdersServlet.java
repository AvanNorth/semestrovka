package tat.itis.servlets;

import tat.itis.model.Service;
import tat.itis.services.ServicesService;
import tat.itis.services.impl.OrdersServiceImpl;
import tat.itis.services.impl.ServicesServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order")
public class OrdersServlet extends HttpServlet {
    private OrdersServiceImpl ordersService;
    private ServicesService servicesService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.ordersService = (OrdersServiceImpl) context.getAttribute("ordersService");
        this.servicesService = (ServicesService) context.getAttribute("servicesService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceId = request.getParameter("serviceId");

        if(serviceId != null){
            Long servId = Long.parseLong(serviceId);
            Service service = servicesService.getServiceById(servId);
            request.setAttribute("service",service);
            request.getRequestDispatcher("orderPreview.ftl").forward(request,response);
        }
    }
}
