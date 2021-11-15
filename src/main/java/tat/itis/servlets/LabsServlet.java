package tat.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import tat.itis.dto.LabDto;
import tat.itis.dto.UserDto;
import tat.itis.model.Lab;
import tat.itis.model.Service;
import tat.itis.services.ServicesService;
import tat.itis.services.SignInService;
import tat.itis.services.impl.LabsServiceImpl;
import tat.itis.services.impl.ServicesServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/labs")
public class LabsServlet extends HttpServlet {

    private LabsServiceImpl labsService;
    private ServicesServiceImpl servicesService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.labsService = (LabsServiceImpl) context.getAttribute("labsService");
        this.servicesService = (ServicesServiceImpl) context.getAttribute("servicesService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String labId = request.getParameter("labId");
        if (labId == null) {
            List<Lab> labList = labsService.getLabs();
            request.setAttribute("labs", labList);
            request.getRequestDispatcher("labs.ftl").forward(request, response);
        } else {
            //TODO проверка на сессию (наверное в фильтре)
            LabDto labsDto = labsService.getLabById(Long.parseLong(labId));
            List<Service> services = servicesService.getLabServices(Long.parseLong(labId));
            request.setAttribute("lab",labsDto);
            request.setAttribute("services",services);
            request.getRequestDispatcher("labPreview.ftl").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
