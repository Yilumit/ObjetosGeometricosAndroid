package br.edu.fateczl.projetomedidorcaloricoandroid.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.projetomedidorcaloricoandroid.model.ExerciciosAcademia;

public class ExerciciosAcademiaDao implements IExerciciosAcademia, ICRUDDao<ExerciciosAcademia> {
    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;

    public ExerciciosAcademiaDao(Context context) {
        this.context = context;
    }

    @Override
    public IExerciciosAcademia open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }

    private static ContentValues getContentValues(ExerciciosAcademia exerciciosAcademia) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", exerciciosAcademia.getCodigo());
        contentValues.put("nome", exerciciosAcademia.getNome());
        contentValues.put("met", exerciciosAcademia.getMet());
        contentValues.put("descricao", exerciciosAcademia.getDescricao());
        contentValues.put("tipo", exerciciosAcademia.getTIPO());

        return contentValues;
    }
    @Override
    public void insert(ExerciciosAcademia exerciciosAcademia) throws SQLException {
        ContentValues contentValues = getContentValues(exerciciosAcademia);
        database.insert("atividade", null, contentValues);
    }

    @Override
    public int update(ExerciciosAcademia exerciciosAcademia) throws SQLException {
        ContentValues contentValues = getContentValues(exerciciosAcademia);
        return database.update("atividade", contentValues, "codigo = " +
                exerciciosAcademia.getCodigo(), null);
    }

    @Override
    public void delete(ExerciciosAcademia exerciciosAcademia) throws SQLException {
        database.delete("atividadde", "codigo = " +
                exerciciosAcademia.getCodigo(), null);
    }

    @SuppressLint("Range")
    @Override
    public ExerciciosAcademia findOne(ExerciciosAcademia exerciciosAcademia) throws SQLException {
        String sql = "SELECT * FROM atividade WHERE codigo =" + exerciciosAcademia.getCodigo();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if (!cursor.isAfterLast()) {
            exerciciosAcademia.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
            exerciciosAcademia.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            exerciciosAcademia.setMet(cursor.getFloat(cursor.getColumnIndex("met")));
            exerciciosAcademia.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));

        }
        cursor.close();
        return exerciciosAcademia;
    }

    @SuppressLint("Range")
    @Override
    public List<ExerciciosAcademia> findAll() throws SQLException {
        ArrayList<ExerciciosAcademia> exerciciosAcademias = new ArrayList<>();
        String sql = "SELECT * FROM atividade";
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while (!cursor.isAfterLast()) {
            ExerciciosAcademia exerciciosAcademia = new ExerciciosAcademia();
            exerciciosAcademia.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
            exerciciosAcademia.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            exerciciosAcademia.setMet(cursor.getFloat(cursor.getColumnIndex("met")));
            exerciciosAcademia.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));

        }
        cursor.close();
        return exerciciosAcademias;
    }
}
