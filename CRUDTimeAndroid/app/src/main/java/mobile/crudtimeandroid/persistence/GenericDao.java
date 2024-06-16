package mobile.crudtimeandroid.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GenericDao extends SQLiteOpenHelper {
    private static final String DATABASE = "TIME.DB";
    private static final int DATABASE_VER = 1;
    private static final String CREATE_TABLE_TIME =
            "CREATE TABLE time ( " +
                    "codigo INT NOT NULL PRIMARY KEY, "+
                    "nome VARCHAR(100) NOT NULL,"+
                    "cidade VARCHAR(50) NOT NULL);";
    private static final String CREATE_TABLE_JOGADOR =
            "CREATE TABLE jogador ( " +
                    "id INT NOT NULL PRIMARY KEY, " +
                    "nome VARCHAR(100) NOT NULL, " +
                    "data_nasc DATA NOT NULL, " +
                    "altura NUMERIC (2) NOT NULL, " +
                    "peso NUMERIC (2) NOT NULL, " +
                    "codigo_time INT NOT NULL, " +
                    "FOREIGN KEY (codigo_time) REFERENCES time(codigo));";

    public GenericDao(Context context){
        super(context, DATABASE, null, DATABASE_VER);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TIME);
        db.execSQL(CREATE_TABLE_JOGADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS time");
            db.execSQL("DROP TABLE IF EXISTS jogador");
            onCreate(db);
        }
    }
}
