package dao;

import dto.Like;

import java.sql.Connection;
import java.util.List;

public class DaoLikesSql implements Dao<Like> {

    private int userId;
    private Connection connection;

    public DaoLikesSql(int userId, Connection connection) {
        this.userId = userId;
        this.connection = connection;
    }

    public void add(Like item) {
        //todo: implement adding a like
    }

    public void remove(int id) {
        //todo: implement removing a like
    }

    public Like get(int id) {
        throw new IllegalStateException("Method is not supplied by this implementation");
    }

    public List<Like> getAll() {
        //todo: implement getting all likes
        return null;
    }
}
