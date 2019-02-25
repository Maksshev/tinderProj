package services;

import dao.Dao;
import dao.DaoLikesSql;
import dao.DaoUsersSql;
import dto.Like;
import dto.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import utils.Freemarker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dao.DaoLikesSql;
import dao.DaoUsersSql;
import dto.Like;
import dto.User;

public class LikesService {

    private int userId;
    private Connection connection;
    private Dao<Like> likeDao;
    private Dao<User> userDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Freemarker freemarker = new Freemarker();

    public LikesService(DaoLikesSql likeDao, DaoUsersSql daoUsers) {
        this.likeDao = likeDao;
        this.daoUsers = daoUsers;
    }

    public LikesService(int userId, Connection connection, HttpServletRequest request, HttpServletResponse response) {
        this.userId = userId;
        this.connection = connection;
        this.request = request;
        this.response = response;
        this.likeDao = new DaoLikesSql(userId, connection);
        this.userDao = new DaoUsersSql(connection);
    }

    public void generateLikedPage() {
        Map<String, Object> input = new HashMap<>();
        input.put("messages", 0);
        input.put("users", getLikedUsersList(likeDao.getAll()));
        freemarker.render("people-list.ftl", input, response);
    }


    private List<User> getLikedUsersList(List<Like> likes) {
        return likes.stream().map(e -> userDao.get(e.getLikedUserId())).collect(Collectors.toList());
    }

    private DaoLikesSql likeDao;
    private DaoUsersSql daoUsers;

    public LikesService(DaoLikesSql likeDao, DaoUsersSql daoUsers) {
        this.likeDao = likeDao;
        this.daoUsers = daoUsers;
    }

    public void removeLike(Like like){
        if(likeDao.get(like.getLikedUserId()) != null){
            likeDao.remove(like.getLikedUserId());
        }
    }

    public void addLike(Like like){
        if(likeDao.get(like.getLikedUserId()) == null){
            likeDao.add(like);
        }
    }

    public void addCheckedStatus(int dislikedUserId){
        likeDao.addCheckedStatus(dislikedUserId);
    }

    public User getUserToShow(int activeUserId){
        User userToShow = daoUsers.getUserToShow(activeUserId);
        if(userToShow == null){
            likeDao.clearCheckedTable();
            return getUserToShow(activeUserId);
        }
        return userToShow;

    }

}
