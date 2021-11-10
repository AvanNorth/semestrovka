package tat.itis.servlets;

import tat.itis.dto.LabDto;
import tat.itis.dto.LabForm;
import tat.itis.dto.UserDto;
import tat.itis.dto.UserForm;
import tat.itis.exceptions.ValidationException;
import tat.itis.services.SignInService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sign-in-lab")
public class SignInLabServlet extends HttpServlet {
    private SignInService signInService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        this.signInService = (SignInService) context.getAttribute("signInService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LabForm form = LabForm.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
        LabDto labDto;

        try {
            labDto = signInService.signInLab(form);
        } catch (ValidationException e) {
            System.out.println(e.getEntity().getMessage());
            response.sendRedirect("/sign-in");
            return;
        }

        response.addCookie(new Cookie("token", labDto.getToken()));
        HttpSession session = request.getSession(true);
        session.setAttribute("lab", labDto);
        response.sendRedirect("/profile");
    }


}
