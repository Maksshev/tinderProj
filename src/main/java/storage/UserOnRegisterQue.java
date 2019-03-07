package storage;

import dto.User;

import java.util.Timer;

public class UserOnRegisterQue {
    private User user;
    private Timer timer;

    public UserOnRegisterQue(User user, Timer timer) {
        this.user = user;
        this.timer = timer;
    }

    public User getUser() {
        return user;
    }

    public Timer getTimer() {
        return timer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserOnRegisterQue that = (UserOnRegisterQue) o;

        return user.getRegUid().equals(that.getUser().getRegUid());
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }

    @Override
    public String toString() {
        return "UserOnRegisterQue{" +
                "user=" + user.toString() +
                '}';
    }
}
