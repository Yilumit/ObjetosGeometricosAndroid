package br.edu.fateczl.projetomedidorcaloricoandroid.persistence;

import java.sql.SQLException;

public interface IExerciciosAcademia {
    public IExerciciosAcademia open() throws SQLException;
    public void close();
}