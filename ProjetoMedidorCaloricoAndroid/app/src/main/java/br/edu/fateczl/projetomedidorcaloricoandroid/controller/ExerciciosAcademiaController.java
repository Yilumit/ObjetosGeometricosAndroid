package br.edu.fateczl.projetomedidorcaloricoandroid.controller;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.projetomedidorcaloricoandroid.model.ExerciciosAcademia;
import br.edu.fateczl.projetomedidorcaloricoandroid.persistence.ExerciciosAcademiaDao;

public class ExerciciosAcademiaController implements IController<ExerciciosAcademia> {
    private final ExerciciosAcademiaDao exDao;

    public ExerciciosAcademiaController(ExerciciosAcademiaDao exDao) {
        this.exDao = exDao;
    }

    @Override
    public void inserir(ExerciciosAcademia exerciciosAcademia) throws SQLException {
        if (exDao.open() == null){
            exDao.open();
        }
        exDao.insert(exerciciosAcademia);
        exDao.close();
    }

    @Override
    public void modificar(ExerciciosAcademia exerciciosAcademia) throws SQLException {
        if (exDao.open() == null){
            exDao.open();
        }
        exDao.update(exerciciosAcademia);
        exDao.close();
    }

    @Override
    public void excluir(ExerciciosAcademia exerciciosAcademia) throws SQLException {
        if (exDao.open() == null){
            exDao.open();
        }
        exDao.delete(exerciciosAcademia);
        exDao.close();
    }

    @Override
    public ExerciciosAcademia buscar(ExerciciosAcademia exerciciosAcademia) throws SQLException {
        if (exDao.open() == null){
            exDao.open();
        }
        return exDao.findOne(exerciciosAcademia);
    }

    @Override
    public List<ExerciciosAcademia> listar() throws SQLException {
        if (exDao.open() == null) {
            exDao.open();
        }
        return exDao.findAll();
    }
}
