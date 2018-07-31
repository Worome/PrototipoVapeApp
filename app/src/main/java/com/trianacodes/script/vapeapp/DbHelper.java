package com.trianacodes.script.vapeapp;

/* Creo esta clase para añadir el código necesario para crear la base de datos si ésta aún no
   existiese o para actualizarla*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.trianacodes.script.vapeapp.sqlite.EstructuraBd;

public class DbHelper extends SQLiteOpenHelper{
    /* Creo dos constantes*/

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Db_Vapeapp";

    public DbHelper(Context contexto){

        super(contexto,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(EstructuraBd.SQL_CREATE_ENTRIES1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(EstructuraBd.SQL_DELETE_ENTRIES1);
        onCreate(db);

    }

}
