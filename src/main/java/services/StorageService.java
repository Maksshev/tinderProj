package services;

import dto.User;
import storage.Storage;
import storage.UserOnRegisterQue;

public class StorageService {

    public void addUid(User uid) {
        Storage.getInstance().setTimer(uid);
    }


    public void removeUid(User uid) {
        Storage.getInstance().remove(uid);
    }

    public UserOnRegisterQue getUserOnRegisterQue(User user) {
        return Storage.getInstance().getUserOnRegisterQue(user);
    }
}
