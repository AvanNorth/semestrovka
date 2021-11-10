package tat.itis.servlets;

import tat.itis.dto.LabDto;
import tat.itis.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = (UserDto) request.getSession(true).getAttribute("user");
        LabDto labDto = (LabDto) request.getSession(true).getAttribute("lab");
        if (userDto != null || labDto != null){
            response.sendRedirect("/profile");
        }else
        request.getRequestDispatcher("sign_in.ftl").forward(request, response);
    }

}
