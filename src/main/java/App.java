import dao.Dao;
import dao.DaoLikesSql;
import dao.DaoUsersSql;
import db.DbConnection;
import dto.Like;
import dto.User;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.LoginServlet;
import servlets.MainServlet;

public class App {

    public static void main(String[] args) throws Exception {

        Dao<User> userDao = new DaoUsersSql(new DbConnection().connection());
        User user = new User("test","test","test","test");

        Dao<Like> likeDao = new DaoLikesSql(1,new DbConnection().connection());

//        Like like2 = new Like(3);
//        likeDao.add(like2);

//        likeDao.getAll()
//                .stream()
//                .forEach(System.out::println);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new MainServlet()),"/");
        handler.addServlet(new ServletHolder(new LoginServlet()),"/login");

//        System.out.println(userDao.get(1));
//        System.out.println(userDao.get(2));
//        System.out.println(userDao.get(3));


        Server server = new Server(80);

        server.start();
        server.join();

    }
}
