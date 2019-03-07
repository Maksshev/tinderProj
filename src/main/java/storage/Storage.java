package storage;

import dto.User;

import java.util.*;

public class Storage {
    private static Storage storage;
    private List<UserOnRegisterQue> usersOnRegisterQue = Collections.synchronizedList(new ArrayList<>());
    private final int MINUTES_OF_ACTIVE_EMAIL_CONFIRMATION = 10;



    private Storage() {}



    public static Storage getInstance() {
        if (storage == null) storage = new Storage();
        return storage;
    }




    public void setTimer(User user) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                storage.remove(user);
            }
        }, MINUTES_OF_ACTIVE_EMAIL_CONFIRMATION * 60 * 1000
        );

        usersOnRegisterQue.add(new UserOnRegisterQue(user, t));
    }

    public void remove(User user) {
        Timer timer = getUserOnRegisterQue(user).getTimer();
        timer.cancel();
        timer.purge();
        usersOnRegisterQue.remove(new UserOnRegisterQue(user, null));
    }

    public UserOnRegisterQue getUserOnRegisterQue(User user) {
        int index = usersOnRegisterQue.indexOf(new UserOnRegisterQue(user, null));
        return index != -1 ? usersOnRegisterQue.get(index) : null;
    }

    public List<UserOnRegisterQue> getUids() {
        return usersOnRegisterQue;
    }


}
