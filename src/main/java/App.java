import db.DbConnection;
import org.eclipse.jetty.server.Handler;
import filters.LoginFilter;
import filters.LoginStatusFilter;
import filters.RegistrationFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import servlets.*;
import utils.ResourceHandlerGenerator;
import websocket.MessagesSocket;

import java.sql.Connection;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class App {

    public static void main(String[] args) throws Exception {

        Connection connection = new DbConnection().connection();

        String webPort = System.getenv("PORT");

        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        ServletContextHandler handler = new ServletContextHandler();

        ResourceHandlerGenerator rhg = new ResourceHandlerGenerator();

        ContextHandler jsHandler = rhg.generateResourceHandler("src/main/resources/templates/js", "/js");

        handler.addServlet(new ServletHolder(new MainServlet()),"/");
        handler.addServlet(new ServletHolder(new LoginServlet(connection)),"/login");
        handler.addServlet(new ServletHolder(new LikesServlet(connection)), "/liked");
        handler.addServlet(new ServletHolder(new MessagesServlet(connection)), "/message");

        //socket

        handler.addServlet(new ServletHolder("ws", MessagesSocketServlet.class), "/messages/*");
        //socket


        handler.addServlet(new ServletHolder(new LoginServlet(connection)),"/login/*");
        handler.addServlet(new ServletHolder(new RegistrationServlet(connection)),"/reg/*");
        handler.addServlet(new ServletHolder(new UsersServlet(connection)),"/users/*");
        handler.addServlet(new ServletHolder(new LogoutServlet()),"/logout/*");
        handler.addServlet(new ServletHolder(new VerifyEmailServlet()), "/verify");
        handler.addServlet(new ServletHolder(new EmailVerificationServlet(connection)), "/verification");

        handler.addFilter(LoginStatusFilter.class,"/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));
        HandlerCollection handlerCollection = new HandlerCollection();

        handler.addFilter(new FilterHolder(new RegistrationFilter(connection)),"/reg/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new LoginFilter(connection)),"/login/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));
        handlerCollection.setHandlers(new Handler[] {jsHandler, handler});

        Server server = new Server(Integer.parseInt(webPort));

        server.setHandler(handlerCollection);

        //test


        //test

        server.start();
        server.join();

    }
}
