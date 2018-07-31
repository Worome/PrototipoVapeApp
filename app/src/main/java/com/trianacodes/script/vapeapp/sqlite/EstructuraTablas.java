package com.trianacodes.script.vapeapp.sqlite;

import java.util.UUID;

public class EstructuraTablas {

    // Creo un interfaz por cada tabla conteniendo los nombres de los campos
    interface CamposAromas{

        final String ID = "id";
        final String NOMBRE_AROMA = "nombre";
        final String MARCA_AROMA = "marca";
        final String TIPO_AROMA = "tipo";
        final String PORCENTAJE_RECOMENDADO = "porcantaje";
        final String MINIMO_MACERACION = "minimo_maceracion";
        final String MAXIMO_MACERACION = "maximo_maceracion";

    }

    // En esta clases creo un identidicador único
    public static class Campos_Aromas implements com.trianacodes.script.vapeapp.sqlite.EstructuraTablas.CamposAromas{

        public static String generarIdAroma(){

            return "AR-" + UUID.randomUUID().toString();

        }

    }

    private EstructuraTablas(){

    }

}
