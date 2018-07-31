package com.trianacodes.script.vapeapp.clases;

public class Aromas {


    /*Creo los argumentos con private para que no se pueda acceder a ellos nada más que desde
    esta clase.*/
    public int Identificador, tiempoMinimoMaceracion, tiempoMaximoMaceracion, porcentajeRecomendado;
    public String Tipo, Nombre, Marca;


    //Creo el constructor
    public Aromas(int identificador, String Nombre, String Marca, String Tipo,
                  int porcentajeRecomendado,int tiempoMinimoMaceracion, int tiempoMaximoMaceracion){

        // Inicializo las propiedades
        this.Identificador = identificador;
        this.Nombre = Nombre;
        this.Marca = Marca;
        this.Tipo = Tipo;
        this.porcentajeRecomendado = porcentajeRecomendado;
        this.tiempoMinimoMaceracion = tiempoMinimoMaceracion;
        this.tiempoMaximoMaceracion = tiempoMaximoMaceracion;

    }

}
