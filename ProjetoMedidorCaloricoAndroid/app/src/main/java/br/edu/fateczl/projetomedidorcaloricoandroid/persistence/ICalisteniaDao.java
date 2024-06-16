package br.edu.fateczl.projetomedidorcaloricoandroid.persistence;

import java.sql.SQLException;

public interface ICalisteniaDao {
    public CalisteniaDao open() throws SQLException;
    public void close();
}
