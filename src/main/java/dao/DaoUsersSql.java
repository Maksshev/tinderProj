package dao;

import dto.User;

import java.sql.Connection;
import java.util.List;

public class DaoUsersSql implements Dao<User> {

    private Connection connection;

    public DaoUsersSql(Connection connection) {
        this.connection = connection;
    }


    public void add(User user) {
        //todo: implement adding a user
    }

    public void remove(int id) {
        throw new IllegalStateException("Method is not supplied by this implementation");
    }

    public User get(int id) {
        //todo: implement getting user by id
        return null;
    }

    public List<User> getAll() {
        throw new IllegalStateException("Method is not supplied by this implementation");
    }

    public List<User> getAllLikedByCurrentUser(int currentUserId, List<Integer> likedUsersIds) {
        //todo: implement getting all users by current user and a list of liked users ids
        return null;
    }
}
