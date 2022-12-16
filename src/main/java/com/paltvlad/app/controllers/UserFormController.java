package com.paltvlad.app.controllers;

import com.paltvlad.app.persist.User;
import com.paltvlad.app.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@WebServlet(urlPatterns = "/user/*")
public class UserFormController extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String [] s = req.getPathInfo().split("/");

        Long id = Long.valueOf(s[1]);



        User user = userRepository.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/user_form.jsp").forward(req, resp);
    }
}
