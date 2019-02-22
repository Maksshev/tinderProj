package dto;

import java.util.List;

public class Like implements Identifiable {
    private int id;
    private List<Integer> likedUsersIds;

    public Like(int userId) {
        this.id = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getLikedUsersIds() {
        return likedUsersIds;
    }

    public void setLikedUsersIds(List<Integer> likedUsersIds) {
        this.likedUsersIds = likedUsersIds;
    }
}
