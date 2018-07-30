package com.trianacodes.script.vapeapp;

/* Creo esta clase para añadir el código necesario para crear la base de datos si ésta aún no
   existiese o para actualizarla*/

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{
    /* Creo dos constantes
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
