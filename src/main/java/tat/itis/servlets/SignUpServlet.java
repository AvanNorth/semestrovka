package tat.itis.servlets;

import tat.itis.dto.LabDto;
import tat.itis.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = (UserDto) request.getSession(true).getAttribute("user");
        LabDto labDto = (LabDto) request.getSession(true).getAttribute("lab");
        if (userDto != null || labDto != null) {
            response.sendRedirect("/profile");
        }else
        request.getRequestDispatcher("sign_up.ftl").forward(request, response);
    }
}
