import db.DbConnection;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.LikesServlet;
import servlets.LoginServlet;
import servlets.MainServlet;
import servlets.MessagesServlet;

import java.sql.Connection;

public class App {

    public static void main(String[] args) throws Exception {

        Connection connection = new DbConnection().connection();


        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new MainServlet()),"/");
        handler.addServlet(new ServletHolder(new LoginServlet()),"/login");
        handler.addServlet(new ServletHolder(new LikesServlet(connection)), "/liked");
        handler.addServlet(new ServletHolder(new MessagesServlet(connection)), "/message");


        HandlerCollection handlerCollection = new HandlerCollection();

        handlerCollection.setHandlers(new Handler[] {handler});


        Server server = new Server(4000);

        server.setHandler(handlerCollection);

        server.start();
        server.join();

    }
}
