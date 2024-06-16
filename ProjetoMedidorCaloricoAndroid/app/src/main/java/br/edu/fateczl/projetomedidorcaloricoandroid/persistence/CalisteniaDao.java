package br.edu.fateczl.projetomedidorcaloricoandroid.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.projetomedidorcaloricoandroid.model.Calistenia;

public class CalisteniaDao implements ICalisteniaDao, ICRUDDao<Calistenia> {

    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;
    public CalisteniaDao(Context context) {
        this.context = context;
    }

    @Override
    public CalisteniaDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }
    private static ContentValues getContentValues(Calistenia calistenia) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", calistenia.getCodigo());
        contentValues.put("nome", calistenia.getNome());
        contentValues.put("met", calistenia.getMet());
        contentValues.put("descricao", calistenia.getDescricao());
        contentValues.put("tipo", calistenia.getTIPO());


        return contentValues;
    }
    @Override
    public void insert(Calistenia calistenia) throws SQLException {
        ContentValues contentValues = getContentValues(calistenia);
        database.insert("atividade", null, contentValues);
    }

    @Override
    public int update(Calistenia calistenia) throws SQLException {
        ContentValues contentValues = getContentValues(calistenia);
        return database.update("atividade", contentValues, "codigo = " +
                calistenia.getCodigo(), null);
    }

    @Override
    public void delete(Calistenia calistenia) throws SQLException {
        database.delete("atividadde", "codigo = " +
                calistenia.getCodigo(), null);
    }

    @SuppressLint("Range")
    @Override
    public Calistenia findOne(Calistenia calistenia) throws SQLException {
        String sql = "SELECT * FROM atividade WHERE codigo =" + calistenia.getCodigo();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if (!cursor.isAfterLast()) {
            calistenia.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
            calistenia.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            calistenia.setMet(cursor.getFloat(cursor.getColumnIndex("met")));
            calistenia.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));

        }
        cursor.close();
        return calistenia;
    }

    @SuppressLint("Range")
    @Override
    public List<Calistenia> findAll() throws SQLException {
        ArrayList<Calistenia> calistenias = new ArrayList<>();
        String sql = "SELECT * FROM atividade";
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while (!cursor.isAfterLast()) {
            Calistenia calistenia = new Calistenia();
            calistenia.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
            calistenia.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            calistenia.setMet(cursor.getFloat(cursor.getColumnIndex("met")));
            calistenia.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));

        }
        cursor.close();
        return calistenias;
    }
}
