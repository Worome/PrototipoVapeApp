package com.trianacodes.script.vapeapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class EstructuraBd {

    /* Creo las constantes para definir el nombre de las tablas, de sus campos y las sentencias de
       creación y eliminación de tabalas. */
    public static final String TABLE_NAME2 = "Aromas";
    private static final String NOMBRE_CAMPO21 = "Id";
    private static final String NOMBRE_CAMPO22 = "Nombre";
    private static final String NOMBRE_CAMPO23 = "Marca";
    private static final String NOMBRE_CAMPO24 = "Tipo";
    private static final String NOMBRE_CAMPO25 = "Porcentaje";
    private static final String NOMBRE_CAMPO26 = "MinMaceracion";
    private static final String NOMBRE_CAMPO27 = "MaxMaceracion";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_AROMAS = "CREATE TABLE " + TABLE_NAME2 +
            " (" + NOMBRE_CAMPO21 + " INTEGER PRIMARY KEY autoincrement, " + NOMBRE_CAMPO22 + TEXT_TYPE +
            COMMA_SEP + NOMBRE_CAMPO23 + TEXT_TYPE + COMMA_SEP + NOMBRE_CAMPO24 + TEXT_TYPE +
            COMMA_SEP + NOMBRE_CAMPO25 + INTEGER_TYPE + COMMA_SEP + NOMBRE_CAMPO26 + INTEGER_TYPE +
            COMMA_SEP + NOMBRE_CAMPO27 + INTEGER_TYPE + " )";

    /*public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME +
            " (" + NOMBRE_CAMPO1 + " INTEGER PRIMARY KEY," + NOMBRE_CAMPO2 + TEXT_TYPE +
            COMMA_SEP + NOMBRE_CAMPO3 + TEXT_TYPE + " )";*/

    /*public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME1;*/
    public static final String SQL_DELETE_AROMAS = "DROP TABLE IF EXISTS " + TABLE_NAME2;

    // Creo objeto de tipo DbHelper
 /*   private DbHelper mantenimientoDb;*/
    // Creo objeto de tipo SQLiteDatabase
    /*private SQLiteDatabase db;*/

    // Creo el constructor
    private EstructuraBd(){

                /* Por si hace falta  generar o modificar la estructura de la base de datos, creo una
        instancia de la clase DbHelper pasándole como parámetro el contexto. Con ésto aún no se
        ejecuta la clase. */

        /*mantenimientoDb = new DbHelper(contexto);*/

        /* Ahora hay que llamar a la clase en la que se define la base de datos (DbHelper). Al
         * hacer esta llamada, si la base de datos existe, nos la devuelve en el modo en el que
         * nosotros le indiquemos (getWritableDatabase) y si no existe, la crea y luego nos la
         * devuelve*/

        /*db = mantenimientoDb.getWritableDatabase();*/

    }

}
