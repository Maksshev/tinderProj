package dao;

import dto.Message;

import java.sql.Connection;
import java.util.List;

public class DaoMessagesSql implements Dao<Message> {

    private Connection connection;
    private int userId;

    public DaoMessagesSql(Connection connection, int userId) {
        this.connection = connection;
        this.userId = userId;
    }

    public void add(Message item) {
        //todo: implement sending message
    }

    public void remove(int id) {
        throw new IllegalStateException("Method is not supplied by this implementation");
    }

    public Message get(int id) {
        //todo: implement getting message by id
        return null;
    }

    public List<Message> getAll() {
        //todo: implement gettind all messages by user id
        return null;
    }
}
