package com.trianacodes.script.vapeapp.sqlite;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.trianacodes.script.vapeapp.clases.Aromas;

/* Creo un algoritmo con el patrón Singleton. Esto significa que creo un constructor principal como
*  privado, defino un método estático de la clase y un método estático que permita la obtención del
*  único miembro. */

public final class OperacionesBasesDeDatos {

    private static DbHelper baseDatos;
    private static OperacionesBasesDeDatos instancia;

    private OperacionesBasesDeDatos(){

    }

    public static OperacionesBasesDeDatos obtenerInstancia(Context contexto){

        if (baseDatos == null){

            baseDatos = new DbHelper(contexto);

        }

        return instancia;

    }

    // Obtengo los registros de la tabla aromas
    public Cursor obtenerAromas(){

        SQLiteDatabase db = baseDatos.getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();


    }

}
