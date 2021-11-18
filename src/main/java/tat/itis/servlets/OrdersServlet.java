package tat.itis.servlets;

import tat.itis.dto.LabDto;
import tat.itis.dto.OrderForm;
import tat.itis.dto.UserDto;
import tat.itis.model.Lab;
import tat.itis.model.Order;
import tat.itis.model.OrderS;
import tat.itis.model.Service;
import tat.itis.services.LabsService;
import tat.itis.services.ServicesService;
import tat.itis.services.impl.LabsServiceImpl;
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
import java.sql.Timestamp;

@WebServlet("/order")
public class OrdersServlet extends HttpServlet {
    private OrdersServiceImpl ordersService;
    private ServicesServiceImpl servicesService;
    private LabsService labsService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.ordersService = (OrdersServiceImpl) context.getAttribute("ordersService");
        this.servicesService = (ServicesServiceImpl) context.getAttribute("servicesService");
        this.labsService = (LabsServiceImpl) context.getAttribute("labsService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceId = request.getParameter("serviceId");
        String orderId = request.getParameter("orderId");
        String statusId = request.getParameter("statusId");
        UserDto user = (UserDto) request.getSession(true).getAttribute("user");
        LabDto labDto = (LabDto) request.getSession(true).getAttribute("lab");

        if(serviceId != null){
            Long servId = Long.parseLong(serviceId);
            Service service = servicesService.getServiceById(servId);
            LabDto lab = labsService.getLabById(service.getLab_id());
            request.setAttribute("service",service);
            request.setAttribute("lab", lab);
            request.getRequestDispatcher("orderPreview.ftl").forward(request,response);
        }
        if(orderId != null && statusId != null){
            Long ordId = Long.parseLong(orderId);
            Long statId = Long.parseLong(statusId);

            OrderS order = ordersService.getOrderById(ordId);

            if(labDto != null && order.getLabId().equals(labDto.getId())){
                request.setAttribute("order",ordersService.changeOrderStatus(order,statId));
                request.setAttribute("lab",labDto);
                request.setAttribute("statuses", ordersService.getAllStatuses());
                request.setAttribute("service",servicesService.getServiceById(order.getServiceId()));

                request.getRequestDispatcher("order.ftl").forward(request,response);
            }else
            response.sendError(403);
        }
        if(orderId != null){
            Long ordId = Long.parseLong(orderId);

            OrderS order = ordersService.getOrderById(ordId);


            if(labDto != null && order.getLabId().equals(labDto.getId()) || user != null && user.getId().equals(order.getUserId())){
                request.setAttribute("order",order);
                request.setAttribute("lab",labDto);
                request.setAttribute("statuses", ordersService.getAllStatuses());
                request.setAttribute("service",servicesService.getServiceById(order.getServiceId()));

                request.getRequestDispatcher("order.ftl").forward(request,response);
            }else
                response.sendError(403);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto user = (UserDto) request.getSession(true).getAttribute("user");

        if(user != null){
            String address = request.getParameter("address");
            String serviceId = request.getParameter("serviceId");

            Long servId = Long.parseLong(serviceId);
            Service service = servicesService.getServiceById(servId);


            System.out.println(address);

            OrderForm orderForm = OrderForm.builder()
                    .userId(user.getId())
                    .labId(service.getLab_id())
                    .cost(service.getPrice())
                    .userAddress(address)
                    .date(new Timestamp(System.currentTimeMillis()))
                    .serviceId(servId)
                    .build();


            OrderS orderS = ordersService.createOrder(orderForm);

            request.setAttribute("order",orderS);
            request.setAttribute("service",service);

            request.getRequestDispatcher("order.ftl").forward(request,response);
        }else {
            request.getRequestDispatcher("sign_in.ftl").forward(request,response);
        }
    }
}
