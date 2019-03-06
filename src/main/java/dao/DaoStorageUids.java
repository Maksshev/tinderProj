package dao;

import storage.Storage;

import java.util.List;

public class DaoStorageUids implements Dao<String> {
    private Storage storage = new Storage();


    @Override
    public void add(String item) {
        storage.getUids().add(item);
    }

    @Override
    public void remove(int id) {
        storage.getUids().remove(id);
    }

    @Override
    public String get(int id) {
        return storage.getUids().get(id);
    }

    @Override
    public List<String> getAll() {
        return storage.getUids();
    }
}
