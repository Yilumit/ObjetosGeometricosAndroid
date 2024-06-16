package br.edu.fateczl.projetomedidorcaloricoandroid.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GenericDao extends SQLiteOpenHelper {


    private static final String DATABASE = "MEDIDOR_DE_CALORIAS.DB";
    private static final int DATABASE_VER = 1;
    private static final String CREATE_TABLE_ATV =
            "CREATE TABLE atividade( " +
                "codigo INT NOT NULL PRIMARY KEY," +
                "nome VARCHAR(100) NOT NULL," +
                "met NUMERIC(1,1) NOT NULL," +
                "descricao VARCHAR(150) NOT NULL," +
                "tipo VARCHAR(50) );";
    public GenericDao(Context context){
        super(context, DATABASE, null, DATABASE_VER);
    }
   
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ATV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion){
            db.execSQL("DROP TABLE IF EXISTS atividade");
            onCreate(db);
        }
    }
}
