package com.paltvlad.app;

import com.paltvlad.app.persist.User;
import com.paltvlad.app.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/user-list-servlet")
public class UserListServlet extends HttpServlet {
    private final UserRepository userRepository = new UserRepository();

    @Override
    public void init() throws ServletException {
        userRepository.insert(new User("User 1"));
        userRepository.insert(new User("User 2"));
        userRepository.insert(new User("User 3"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");


        for (User user : userRepository.findAll()) {
            resp.getWriter().printf("<h2>" + user.getId() + " " + user.getUsername() + "</h2>");
        }

        resp.getWriter().printf("</body></html>");

    }
}
