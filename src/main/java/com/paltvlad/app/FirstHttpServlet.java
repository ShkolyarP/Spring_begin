package com.paltvlad.app;


import com.paltvlad.app.persist.User;
import com.paltvlad.app.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/first_http_servlet/*")
public class FirstHttpServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello from HTTP servlet</h1>");

//        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
//        resp.getWriter().println("<p>servletPath: " + req.getServletPath() + "</p>");
//        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
//        resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");
//        resp.getWriter().println("<p>param1: " + req.getParameter("param1") + "</p>");
//        resp.getWriter().println("<p>param2: " + req.getParameter("param2") + "</p>");

        PrintWriter wr = resp.getWriter();
        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Username</th>");
        wr.println("</tr>");

        for (User user : userRepository.findAll()) {
            wr.println("<tr>");
            wr.println("<td><a href='" + getServletContext().getContextPath() + "/user/" + user.getId() + "'>" + user.getId() + "</a></td>");
            wr.println("<td>" + user.getUsername() + "</td>");
            wr.println("</tr>");
        }

        wr.println("</table>");
    }
}
