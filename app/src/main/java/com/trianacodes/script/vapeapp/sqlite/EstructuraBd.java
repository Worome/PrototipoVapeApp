package com.trianacodes.script.vapeapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class EstructuraBd {

    /* Creo las constantes para definir el nombre de las tablas, de sus campos y las sentencias de
       creación y eliminación de tabalas. */
    public static final String TABLA_AROMA = "Aromas";
    public static final String AROMA_ID = "Id";
    public static final String AROMA_NOMBRE = "Nombre";
    public static final String AROMA_MARCA = "Marca";
    public static final String AROMA_TIPO = "Tipo";
    public static final String AROMA_PORCENTAJE = "Porcentaje";
    public static final String AROMA_MIN_MACERACION = "MinMaceracion";
    public static final String AROMA_MAX_MACERACION = "MaxMaceracion";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_AROMAS = "CREATE TABLE " + TABLA_AROMA +
            " (" + AROMA_ID + " TEXT PRIMARY KEY autoincrement, " + AROMA_NOMBRE + TEXT_TYPE +
            COMMA_SEP + AROMA_MARCA + TEXT_TYPE + COMMA_SEP + AROMA_TIPO + TEXT_TYPE +
            COMMA_SEP + AROMA_PORCENTAJE + INTEGER_TYPE + COMMA_SEP + AROMA_MIN_MACERACION + INTEGER_TYPE +
            COMMA_SEP + AROMA_MAX_MACERACION + INTEGER_TYPE + " )";

    public static final String SQL_DELETE_AROMAS = "DROP TABLE IF EXISTS " + TABLA_AROMA;

    // Creo el constructor
    private EstructuraBd(){

    }

}
