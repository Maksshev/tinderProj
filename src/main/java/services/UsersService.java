package services;

import dao.Dao;
import dto.User;

public class UsersService {
    private Dao<User> userDao;

    public UsersService(Dao<User> userDao) {
        this.userDao = userDao;
    }

    public boolean userExists(User user){
        return userDao.get(user.getId()) != null;
    }

    public boolean checkPassword(User user){
        return userDao.get(user.getId()).getPassword().equals(user.getPassword());
    }

    public void add(User item) {
        userDao.add(item);
    }

    public User get(int id) {
        return userDao.get(id);
    }

}
