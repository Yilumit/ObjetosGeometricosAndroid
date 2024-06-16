package mobile.crudtimeandroid.controller;

import java.sql.SQLException;
import java.util.List;

import mobile.crudtimeandroid.model.Jogador;
import mobile.crudtimeandroid.persistence.JogadorDao;

public class JogadorController implements IController<Jogador> {

    private final JogadorDao jDao;

    public JogadorController(JogadorDao jDao) {
        this.jDao = jDao;
    }

    @Override
    public void insert(Jogador jogador) throws SQLException {
        if (jDao.open() == null){
            jDao.open();
        }
        jDao.isert(jogador);
        jDao.close();
    }

    @Override
    public void update(Jogador jogador) throws SQLException {
        if (jDao.open() == null){
            jDao.open();
        }
        jDao.update(jogador);
        jDao.close();
    }

    @Override
    public void delete(Jogador jogador) throws SQLException {
        if (jDao.open() == null){
            jDao.open();
        }
        jDao.delete(jogador);
        jDao.close();
    }

    @Override
    public Jogador findOne(Jogador jogador) throws SQLException {
        if (jDao.open() == null){
            jDao.open();
        }
        return jDao.findOne(jogador);
    }

    @Override
    public List<Jogador> findAll() throws SQLException {
        if (jDao.open() == null){
            jDao.open();
        }
        return jDao.findAll();
    }
}
