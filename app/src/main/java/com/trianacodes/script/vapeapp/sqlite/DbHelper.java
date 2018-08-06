package com.trianacodes.script.vapeapp.sqlite;

/* Creo esta clase para añadir el código necesario para crear la base de datos si ésta aún no
   existiese o para actualizarla*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
/*Importo las clase Campos_Aromas que está en la clase EstructuraTablas y que lo que hace es
  generar el ID */

public class DbHelper extends SQLiteOpenHelper{

    /* Creo dos constantes*/

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Db_Vapeapp";
    private final Context contexto;

    public DbHelper(Context contextoActual){

        super(contextoActual,DATABASE_NAME,null,DATABASE_VERSION);
        this.contexto = contextoActual;

    }

    // Aquí doy las instrucciones para crear las tablas
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(EstructuraBd.SQL_CREATE_AROMAS);
        // Aquí debe seguir creando el resto de las tablas

    }

    // Aquí doy las instrucciones para actualizar la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(EstructuraBd.SQL_DELETE_AROMAS);
        onCreate(db);

    }

}
