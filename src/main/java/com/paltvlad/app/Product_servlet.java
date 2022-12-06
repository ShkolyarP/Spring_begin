package com.paltvlad.app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Product_servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");

        for (int i = 0; i < 10; i++) {
            Product product = new Product(i, "product" + i, (i + 21) * 21 + 1);
            resp.getWriter().printf("<h2>" + product.getId() + " " + product.getTitle() + " " + product.getCoast() + "</h2>");
        }
        resp.getWriter().printf("</body></html>");

    }
}
