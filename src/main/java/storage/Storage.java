package storage;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<String> uids = new ArrayList<>();



    void setTimer() {

    }

    void remove(int index) {
        uids.remove(index);
    }

    public List<String> getUids() {
        return uids;
    }


}
