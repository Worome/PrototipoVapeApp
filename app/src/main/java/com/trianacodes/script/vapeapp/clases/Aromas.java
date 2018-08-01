package com.trianacodes.script.vapeapp.clases;

public class Aromas {


    /*Creo los argumentos con private para que no se pueda acceder a ellos nada más que desde
    esta clase.*/
    public int tiempoMinimoMaceracion, tiempoMaximoMaceracion, porcentajeRecomendado;
    public String Identificador, Tipo, Nombre, Marca;


    //Creo el constructor
    public Aromas(String identificador, String Nombre, String Marca, String Tipo,
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
