package services;

import dao.DaoLikesSql;
import dao.DaoUsersSql;
import dto.Like;
import dto.User;

public class LikesService {
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
