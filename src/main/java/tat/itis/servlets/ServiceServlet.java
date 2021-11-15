package tat.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import tat.itis.dto.LabDto;
import tat.itis.dto.LabForm;
import tat.itis.dto.ServiceDto;
import tat.itis.dto.ServiceForm;
import tat.itis.exceptions.ValidationException;
import tat.itis.model.Lab;
import tat.itis.model.Service;
import tat.itis.services.ServicesService;
import tat.itis.services.SignInService;
import tat.itis.services.validation.ErrorEntity;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@WebServlet("/edit-service")
public class ServiceServlet extends HttpServlet {
    private ServicesService service;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        this.objectMapper = (ObjectMapper) config.getServletContext().getAttribute("objectMapper");
        this.service = (ServicesService) context.getAttribute("servicesService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LabDto labDto = (LabDto) request.getSession(true).getAttribute("lab");
        String serviceId = request.getParameter("serviceId");
        if (labDto != null && serviceId == null) {
            List<Service> serviceList = service.getLabServices(labDto.getId());
            request.setAttribute("services", serviceList);
        } else if (labDto != null) {
            Service serviceD = service.getServiceById(Long.parseLong(serviceId));
            serviceD.setLab_id(labDto.getId());
            objectMapper.writeValue(response.getOutputStream(), serviceD);
            response.setContentType("application/json");
        } else
            response.sendError(403);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceForm form;
        Service addedService;
        LabDto labDto = (LabDto) request.getSession(true).getAttribute("lab");

        String sid = request.getParameter("id");

        request.setCharacterEncoding("UTF-8");

        form = ServiceForm.builder()
                .lab_id(labDto.getId())
                .name(request.getParameter("name"))
                .description(request.getParameter("description"))
                .price(Long.parseLong(request.getParameter("price")))
                .build();

        System.out.println(request.getParameter("description"));

        if (sid != null) {
            addedService = service.saveLabServiceById(form,Long.parseLong(sid));
            objectMapper.writeValue(response.getOutputStream(), addedService);
            response.setContentType("application/json");
        } else {
            addedService = service.saveLabService(form);
            objectMapper.writeValue(response.getOutputStream(), addedService);
            response.setContentType("application/json");
        }

    }
}
