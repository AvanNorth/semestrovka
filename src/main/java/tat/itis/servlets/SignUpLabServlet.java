package tat.itis.servlets;

import tat.itis.dto.LabForm;
import tat.itis.dto.UserForm;
import tat.itis.exceptions.ValidationException;
import tat.itis.services.SignUpService;
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
import java.util.Set;

@WebServlet("/sign-up-lab")
public class SignUpLabServlet extends HttpServlet {

    private SignUpService signUpService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        this.signUpService = (SignUpService) context.getAttribute("signUpService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LabForm form;
        try {
            form = LabForm.builder()
                    .name(request.getParameter("name"))
                    .email(request.getParameter("email"))
                    .password(request.getParameter("password"))
                    .phone(Long.valueOf(request.getParameter("phone")))
                    .build();
        } catch (NumberFormatException e) {
            Set<ErrorEntity> errors = new HashSet<>();
            errors.add(ErrorEntity.INVALID_REQUEST);
            request.setAttribute("signUpErrors", errors);
            request.getRequestDispatcher("sign_up.ftl").forward(request, response);
            return;
        }

        try {
            signUpService.signUp(form);
        } catch (ValidationException e) {
            request.setAttribute("signUpError", e.getEntity());
            request.getRequestDispatcher("sign_up.ftl").forward(request, response);
            return;
        }
        response.sendRedirect("/sign-in");
    }


}
