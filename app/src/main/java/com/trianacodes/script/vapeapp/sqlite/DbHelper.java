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

    /* Creo una interface con los nombres de las tablas*/
    /*interface Tablas{

        String TABLA_AROMAS = "aromas";

    }*/

    /* Establezco las referencias de las campos clave de cada tabla. Con el uso de la palabra
    *  REFERENCES para establecer las claves externas.*/
    /*interface Referencias {

        String ID_AROMAS = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.TABLA_AROMAS, Campos_Aromas.ID);

       // Las líneas restantes son ejemplos que más adelante me pueden servir

        String ID_PRODUCTO = String.format("REFERENCES %s(%s)",
                Tablas.PRODUCTO, Productos.ID);

        String ID_CLIENTE = String.format("REFERENCES %s(%s)",
                Tablas.CLIENTE, Clientes.ID);

        String ID_FORMA_PAGO = String.format("REFERENCES %s(%s)",
                Tablas.FORMA_PAGO, FormasPago.ID);
    }*/

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

    @Override
    public void onOpen(SQLiteDatabase db){

        super.onOpen(db);
        /* Con las siguientes líneas hago efectivas las referencias de integridad de las claves
        *  foráneas*/
        if (!db.isReadOnly()){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){

                db.setForeignKeyConstraintsEnabled(true);

            } else {

                db.execSQL("PRAGMA foreing_keys=ON");

            }

        }

    }

}
