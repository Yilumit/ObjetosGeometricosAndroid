package mobile.crudtimeandroid.controller;

import java.sql.SQLException;
import java.util.List;

import mobile.crudtimeandroid.model.Time;
import mobile.crudtimeandroid.persistence.TimeDao;

public class TimeController implements IController<Time>{

    private final TimeDao tDao;

    public TimeController(TimeDao tDao) {
        this.tDao = tDao;
    }


    @Override
    public void insert(Time time) throws SQLException {
        if (tDao.open() == null){
            tDao.open();
        }
        tDao.isert(time);
        tDao.close();
    }

    @Override
    public void update(Time time) throws SQLException {
        if (tDao.open() == null){
            tDao.open();
        }
        tDao.update(time);
        tDao.close();
    }

    @Override
    public void delete(Time time) throws SQLException {
        if (tDao.open() == null){
            tDao.open();
        }
        tDao.delete(time);
        tDao.close();
    }

    @Override
    public Time findOne(Time time) throws SQLException {
        if (tDao.open() == null){
            tDao.open();
        }
        return tDao.findOne(time);

    }

    @Override
    public List<Time> findAll() throws SQLException {
        if (tDao.open() == null){
            tDao.open();
        }
        return tDao.findAll();
    }
}
