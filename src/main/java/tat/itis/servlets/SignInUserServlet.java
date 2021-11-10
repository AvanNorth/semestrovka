package tat.itis.servlets;

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

@WebServlet("/sign-in-user")
public class SignInUserServlet extends HttpServlet {
    private SignInService signInService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        this.signInService = (SignInService) context.getAttribute("signInService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserForm form = UserForm.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
        UserDto userDto;

        try {
            userDto = signInService.signInUser(form);
        } catch (ValidationException e) {
            System.out.println(e.getEntity().getMessage());
            response.sendRedirect("/sign-in");
            return;
        }

        response.addCookie(new Cookie("token", userDto.getToken()));
        HttpSession session = request.getSession(true);
        session.setAttribute("user", userDto);
        response.sendRedirect("/profile");
    }

}
