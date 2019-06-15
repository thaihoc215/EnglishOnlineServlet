package com.hochnt.controller.admin;

import com.hnthoc.core.dto.UserDTO;
import com.hnthoc.core.web.utils.FormUtil;
import com.hochnt.command.UserCommand;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp"); // muon hien thi view nao thif truyen path cua file jsp vao (views)
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*log.error("jsp servlet test hnthoc");
        String name = req.getParameter("name");
        String password = req.getParameter("password");*/
        UserCommand command = FormUtil.populate(UserCommand.class, req);
        UserDTO pojo = command.getPojo();
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp"); // muon hien thi view nao thif truyen path cua file jsp vao (views)
        rd.forward(req, resp);
    }
}
