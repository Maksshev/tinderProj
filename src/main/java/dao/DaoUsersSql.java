package dao;

import dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoUsersSql implements Dao<User> {

    private Connection connection;

    public DaoUsersSql(Connection connection) {
        this.connection = connection;
    }


    public void add(User user) {
        String sql= "INSERT INTO tinderam_users(login, password, name, surname) VALUES (?,?,?,?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,user.getLogin());
            stm.setString(2,user.getPassword());
            stm.setString(3,user.getName());
            stm.setString(4,user.getSurname());
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        throw new IllegalStateException("Method is not supplied by this implementation");
    }

    public User get(int id) {
        User user = null;

        String sql = String.format("SELECT * FROM tinderam_users WHERE id = %d",id);
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rSet = stm.executeQuery();

            if(rSet.next()){
                String name = rSet.getString("name");
                String surname = rSet.getString("surname");
                String login = rSet.getString("login");
                String imgUrl = rSet.getString("imgUrl") == null ? "" : rSet.getString("imgUrl");
                user = new User(id,login,name,surname,imgUrl);
            }

        }   catch (SQLException e){
            e.printStackTrace();
        }

        return user;

    }

    public List<User> getAll() {
        throw new IllegalStateException("Method is not supplied by this implementation");
    }

//    public List<User> getAllLikedByCurrentUser(int currentUserId, List<Integer> likedUsersIds) {
//        //todo: implement getting all users by current user and a list of liked users ids
//        return null;
//    }
}
