import db.DbConnection;
import filters.LoginFilter;
import filters.LoginStatusFilter;
import filters.RegistrationFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.LoginServlet;
import servlets.MainServlet;
import servlets.RegistrationServlet;
import servlets.UsersServlet;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.util.EnumSet;

public class App {

    public static void main(String[] args) throws Exception {

        Connection connection = new DbConnection().connection();

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new MainServlet()),"/");
        handler.addServlet(new ServletHolder(new LoginServlet(connection)),"/login/*");
        handler.addServlet(new ServletHolder(new RegistrationServlet(connection)),"/reg/*");
        handler.addServlet(new ServletHolder(new UsersServlet(connection)),"/users/*");

        handler.addFilter(LoginStatusFilter.class,"/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));

        handler.addFilter(new FilterHolder(new RegistrationFilter(connection)),"/reg/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new LoginFilter(connection)),"/login/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));

        Server server = new Server(80);

        server.setHandler(handler);

        server.start();
        server.join();

    }
}
