package dao;

import dto.Like;
import dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoLikesSql implements Dao<Like> {

    private int userId;
    private Connection connection;

    public DaoLikesSql(int userId, Connection connection) {
        this.userId = userId;
        this.connection = connection;
    }

    public void add(Like item) {
        String sql = "INSERT INTO tinderam_likes(userId,liked) VALUES (?,?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, item.getLikedUserId());
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        throw new IllegalStateException("Method is not supplied by this implementation");
    }

    public Like get(int id) {
        throw new IllegalStateException("Method is not supplied by this implementation");
    }

    public List<Like> getAll() {
        List<Like> likes = new ArrayList<>();
        String sql = "SELECT * FROM tinderam_likes WHERE userId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            ResultSet rSet = stm.executeQuery();

            while (rSet.next()) {
                int userId = rSet.getInt("userId");
                int likedUserId = rSet.getInt("liked");
                Like like = new Like(userId,likedUserId);
                likes.add(like);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likes;
    }
}
