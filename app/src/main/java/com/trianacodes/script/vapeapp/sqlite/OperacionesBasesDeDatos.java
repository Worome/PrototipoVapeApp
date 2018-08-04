package com.trianacodes.script.vapeapp.sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.trianacodes.script.vapeapp.sqlite.EstructuraBd;
import com.trianacodes.script.vapeapp.sqlite.EstructuraTablas;

import com.trianacodes.script.vapeapp.clases.Aromas;

/* Creo un algoritmo con el patrón Singleton. Esto significa que creo un constructor principal como
*  privado, defino un método estático de la clase y un método estático que permita la obtención del
*  único miembro. */

public final class OperacionesBasesDeDatos {

    private static DbHelper baseDatos;
    private static OperacionesBasesDeDatos instancia = new OperacionesBasesDeDatos();
    // Creo una constante que contiene el nombre de la tabla sobre la que se va a hacer la consulta
    private static final String CONSULTA_AROMAS = "Aromas";

    /* Esto es un ejemplo más complicado que el de la línea de arriba en la que se indican varias
       tablas unidas por JOINs */
    /*private static final String CABECERA_PEDIDO_JOIN_CLIENTE_Y_FORMA_PAGO = "cabecera_pedido " +
            "INNER JOIN cliente " +
            "ON cabecera_pedido.id_cliente = cliente.id " +
            "INNER JOIN forma_pago " +
            "ON cabecera_pedido.id_forma_pago = forma_pago.id";*/

    /* Este variable de tipo array se usa dentro de la instrucción builder.query, que es el que
       obliga a que dicha variable sea un array. En ella se establece el contenido del SELECT de
       la consulta, es decir los campos que se quieren mostrar en una consulta.*/
    private final String[] resultado = new String[]{
            EstructuraBd.TABLE_NAME2 + "." + EstructuraTablas.Campos_Aromas.ID,
            EstructuraTablas.Campos_Aromas.NOMBRE_AROMA, EstructuraTablas.Campos_Aromas.MARCA_AROMA,
            EstructuraTablas.Campos_Aromas.TIPO_AROMA,
            EstructuraTablas.Campos_Aromas.PORCENTAJE_RECOMENDADO,
            EstructuraTablas.Campos_Aromas.MINIMO_MACERACION,
            EstructuraTablas.Campos_Aromas.MAXIMO_MACERACION};

            /*Tablas.CABECERA_PEDIDO + "." + CabecerasPedido.ID,
            CabecerasPedido.FECHA,
            Clientes.NOMBRES,
            Clientes.APELLIDOS,
            FormasPago.NOMBRE};*/

    private OperacionesBasesDeDatos(){

    }

    public static OperacionesBasesDeDatos obtenerInstancia(Context contexto){

        if (baseDatos == null){

            baseDatos = new DbHelper(contexto);

        }

        return instancia;

    }

    public SQLiteDatabase getDb(){

        return baseDatos.getWritableDatabase();

    }

    // Obtengo todos los registros de la tabla aromas
    public Cursor obtenerAromas(){

        SQLiteDatabase db = baseDatos.getReadableDatabase();
        /* Se usa la clase SQLiteQueryBuilder para hacer consultas complejas que puedan implicar
           joins. Si la consulta afecta a una sola tabla se puede usar el método rawQuery().*/
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        // El método setTables establece sobre qué tabla se va a realizar la consulta.
        builder.setTables(CONSULTA_AROMAS);
        return builder.query(db, resultado,null,null,null, null, null);

    }

    /* Si se quiere obtener sólo un registro dependiendo del valor de alguno de sus campo
       (SELECT... WHERE) se haría de la siguiente forma: */
    public Cursor obtenerAromaPorId(String id){

        SQLiteDatabase db = baseDatos.getWritableDatabase();
        String where = String.format("%s=?", EstructuraTablas.Campos_Aromas.ID);
        String[] argWhere = {id};
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(CONSULTA_AROMAS);
        return builder.query(db,resultado,where,argWhere,null,null,null);

    }

    /* Para insertar registros en una tabla se haría como viene abajo. El parámetro que recibe el
       método insertarAroma es un objeto (aroma) de la clase Aromas*/
    public String insertarAroma(Aromas aroma){

        SQLiteDatabase db = baseDatos.getWritableDatabase();
        // Genero el Id del registro que es a su vez, la clave primaria
        String idAroma = EstructuraTablas.Campos_Aromas.generarIdAroma();
        /* Creo el contenedor donde se almacenarán los valores de cada campo del regitro*/
        ContentValues valores = new ContentValues();
        /* Almaceno en cada campo del registro (Campos_Aromas.NOMBRE_AROMA, por ejemplo), el
        *  valor establecido por el usuario (aroma.Nombre) */
        valores.put(EstructuraTablas.Campos_Aromas.ID, idAroma);
        valores.put(EstructuraTablas.Campos_Aromas.NOMBRE_AROMA, aroma.getNombre());
        valores.put(EstructuraTablas.Campos_Aromas.MARCA_AROMA, aroma.getMarca());
        valores.put(EstructuraTablas.Campos_Aromas.TIPO_AROMA, aroma.getTipo());
        valores.put(EstructuraTablas.Campos_Aromas.PORCENTAJE_RECOMENDADO,
                aroma.getPorcentajeRecomendado());
        valores.put(EstructuraTablas.Campos_Aromas.MINIMO_MACERACION, aroma.getTiempoMaximoMaceracion());
        valores.put(EstructuraTablas.Campos_Aromas.MAXIMO_MACERACION, aroma.getTiempoMaximoMaceracion());
        //Inserto el registro
        db.insertOrThrow(CONSULTA_AROMAS,null,valores);
        // Devuelvo el id generado;
        return idAroma;

    }

    /* Para actualizar un registro:*/
    public boolean actualizarAroma(Aromas aroma){

        SQLiteDatabase db = baseDatos.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(EstructuraTablas.Campos_Aromas.NOMBRE_AROMA, aroma.getNombre());
        valores.put(EstructuraTablas.Campos_Aromas.MARCA_AROMA, aroma.getMarca());
        valores.put(EstructuraTablas.Campos_Aromas.TIPO_AROMA, aroma.getTipo());
        valores.put(EstructuraTablas.Campos_Aromas.PORCENTAJE_RECOMENDADO,
                aroma.getPorcentajeRecomendado());
        valores.put(EstructuraTablas.Campos_Aromas.MINIMO_MACERACION, aroma.getTiempoMinimoMaceracion());
        valores.put(EstructuraTablas.Campos_Aromas.MAXIMO_MACERACION, aroma.getTiempoMaximoMaceracion());
        // Defino la cláusula Where necesaria para modificar el registro concreto
        String where = String.format("%s=?", EstructuraTablas.Campos_Aromas.ID);
        // Establezco el valor por el que se tiene que hacer el WHERE
        String[] whereArgs = {aroma.Identificador};
        int resultado = db.update(CONSULTA_AROMAS, valores, where,whereArgs);
        return resultado > 0;

    }

    /*Eliminación de un registro*/
    public boolean eliminarAroma(String id){

        SQLiteDatabase db = baseDatos.getWritableDatabase();
        String where = EstructuraTablas.Campos_Aromas.ID + " =? ";
        String[] whereArgs = {id};
        int resultado = db.delete(CONSULTA_AROMAS,where,whereArgs);
        return resultado > 0;

    }

}
