package servlets;

import dao.DaoUsersSql;
import dto.User;
import services.CookiesService;
import services.StorageService;
import services.UsersService;
import storage.UserOnRegisterQue;
import utils.Freemarker;
import utils.ParameterFromRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

public class EmailVerificationServlet extends HttpServlet {
    private final Freemarker f = new Freemarker();
    private UsersService usersService;
    private final Connection connection;

    public EmailVerificationServlet(Connection connection) {
        this.connection = connection;
        this.usersService = new UsersService(new DaoUsersSql(connection));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParameterFromRequest pfr = new ParameterFromRequest(req);
        StorageService storageService = new StorageService();
        CookiesService cookiesService = new CookiesService(req,resp);
        String uid = pfr.getStr("u");
        User exemplaryUser = new User(uid);
        UserOnRegisterQue userInQue = storageService.getUserOnRegisterQue(exemplaryUser);

        if (userInQue != null) {
            usersService.add(userInQue.getUser());
            cookiesService.addCookie(usersService.getUserId(userInQue.getUser()));
            storageService.removeUid(userInQue.getUser());
            resp.sendRedirect("/users");
        } else {
            HashMap<String, Object> data = new HashMap<>();
            data.put("message", "Link has expired, try registering again");
            data.put("rout","/reg");
            f.render("fail.ftl", data,(HttpServletResponse) resp);
        }

    }
}
