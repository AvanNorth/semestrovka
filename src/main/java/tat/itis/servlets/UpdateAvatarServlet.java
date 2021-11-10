package tat.itis.servlets;

import tat.itis.dto.LabDto;
import tat.itis.dto.UserDto;
import tat.itis.model.FileInfo;
import tat.itis.services.FileService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update-avatar")
@MultipartConfig
public class UpdateAvatarServlet extends HttpServlet {
    private FileService filesService;

    @Override
    public void init(ServletConfig config) {
        this.filesService = (FileService) config.getServletContext().getAttribute("filesService");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("file");
        HttpSession session = request.getSession(true);
        UserDto userDto = (UserDto) session.getAttribute("user");
        LabDto labDto = (LabDto) session.getAttribute("lab");
        if(userDto !=null){
            FileInfo fileInfo = filesService.saveFileToStorage(
                    userDto,
                    part.getInputStream(),
                    part.getSubmittedFileName(),
                    part.getContentType(),
                    part.getSize());
            userDto.setAvatarId(fileInfo.getId());
            session.setAttribute("user", userDto);
            response.sendRedirect("/files/" + fileInfo.getId());
        }else if (labDto != null){
            FileInfo fileInfo = filesService.saveFileToStorage(
                    labDto,
                    part.getInputStream(),
                    part.getSubmittedFileName(),
                    part.getContentType(),
                    part.getSize());
            labDto.setAvatarId(fileInfo.getId());
            session.setAttribute("user", labDto);
            response.sendRedirect("/files/" + fileInfo.getId());
        }else
            response.sendError(403);
    }
}