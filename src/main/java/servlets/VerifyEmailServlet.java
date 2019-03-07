package servlets;

import utils.Freemarker;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class VerifyEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Freemarker freemarker = new Freemarker();
        HashMap<String, Object> data = new HashMap<>();
        data.put("message", "Check your email to complete registration");
        data.put("rout","/reg");
        freemarker.render("fail.ftl", data,(HttpServletResponse) resp);
    }

}
