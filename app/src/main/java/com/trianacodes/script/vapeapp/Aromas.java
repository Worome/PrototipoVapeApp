package com.trianacodes.script.vapeapp;

public class Aromas {


    /*Creo los argumentos con private para que no se pueda acceder a ellos nada ás que desde
    esta clase.*/
    private int Identificador, tiempoMinimoMaceracion, tiempoMaximoMaceracion, porcentajeRecomendado;
    private String Tipo, Nombre, Marca   ;


    //Creo el constructor
    public Aromas(int identificador, int tiempoMinimoMaceracion, int tiempoMaximoMaceracion,
                  int porcentajeRecomendado, String Tipo, String Nombre, String Marca){

        // Inicializo las propiedades
        this.Identificador = identificador;
        this.tiempoMinimoMaceracion = tiempoMinimoMaceracion;
        this.tiempoMaximoMaceracion = tiempoMaximoMaceracion;
        this.porcentajeRecomendado = porcentajeRecomendado;
        this.Tipo = Tipo;
        this.Nombre = Nombre;
        this.Marca = Marca;

    }

    public void setIdentificador(int id){

        int numeraId = id++;

    }

}
