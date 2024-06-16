package br.edu.fateczl.projetomedidorcaloricoandroid.controller;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.projetomedidorcaloricoandroid.model.Calistenia;
import br.edu.fateczl.projetomedidorcaloricoandroid.persistence.CalisteniaDao;

public class CalisteniaController implements IController<Calistenia> {

    private final CalisteniaDao cDao;

    public CalisteniaController(CalisteniaDao cDao) {
        this.cDao = cDao;
    }


    @Override
    public void inserir(Calistenia calistenia) throws SQLException {
        if (cDao.open() == null){
            cDao.open();
        }
        cDao.insert(calistenia);
        cDao.close();
    }

    @Override
    public void modificar(Calistenia calistenia) throws SQLException {
        if (cDao.open() == null){
            cDao.open();
        }
        cDao.update(calistenia);
        cDao.close();
    }

    @Override
    public void excluir(Calistenia calistenia) throws SQLException {
        if (cDao.open() == null){
            cDao.open();
        }
        cDao.delete(calistenia);
        cDao.close();
    }

    @Override
    public Calistenia buscar(Calistenia calistenia) throws SQLException {
        if (cDao.open() == null){
            cDao.open();
        }
        return cDao.findOne(calistenia);

    }

    @Override
    public List<Calistenia> listar() throws SQLException {
        if (cDao.open() == null){
            cDao.open();
        }
        return cDao.findAll();
    }
}
