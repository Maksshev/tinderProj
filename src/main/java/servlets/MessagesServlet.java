package servlets;

import services.MessagesService;
import utils.ParameterFromRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class MessagesServlet extends HttpServlet {

    private Connection connection;

    public MessagesServlet(Connection connection) {
        this.connection = connection;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        todo: dont hardcode userId
        int userId = 3;
        ParameterFromRequest pfr = new ParameterFromRequest(req);
        int counterpartId = pfr.getInt("user");

        MessagesService messagesService = new MessagesService(userId, counterpartId, connection, req, resp);
        messagesService.generateLikedPage();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        todo: dont hardcode userId
        int userId = 3;
        ParameterFromRequest pfr = new ParameterFromRequest(req);
        int counterpartId = pfr.getInt("user");
        String text = pfr.getStr("text");
        MessagesService messagesService = new MessagesService(userId, counterpartId, connection, req, resp);
        messagesService.sendMessage(text);
        messagesService.generateLikedPage();
    }
}
