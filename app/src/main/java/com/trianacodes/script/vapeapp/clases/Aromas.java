package com.trianacodes.script.vapeapp.clases;

public class Aromas {


    /*Creo los argumentos con private para que no se pueda acceder a ellos nada más que desde
    esta clase.*/
    private int tiempoMinimoMaceracion, tiempoMaximoMaceracion, porcentajeRecomendado;
    private String Tipo, Nombre, Marca;
    public String Identificador;

    /*Creo el constructor que tiene que ser public y en el que se tiene que dar los valores
      iniciales a cada una de sus propiedades.*/

    public Aromas(){

        this.Identificador = "";
        this.Nombre = "";
        this.Marca = "";
        this.Tipo = "";
        this.porcentajeRecomendado = 0;
        this.tiempoMinimoMaceracion = 0;
        this.tiempoMaximoMaceracion = 0;

    }

    /* Este es un ejemplo de constructor en el que al crearse un nuevo objeto habría que pasarle
     todos estos argumentos*/
    /*public Aromas(String identificador, String Nombre, String Marca, String Tipo,
                  int porcentajeRecomendado,int tiempoMinimoMaceracion, int tiempoMaximoMaceracion){


        // Inicializo las propiedades
        this.Identificador = identificador;
        this.Nombre = Nombre;
        this.Marca = Marca;
        this.Tipo = Tipo;
        this.porcentajeRecomendado = porcentajeRecomendado;
        this.tiempoMinimoMaceracion = tiempoMinimoMaceracion;
        this.tiempoMaximoMaceracion = tiempoMaximoMaceracion;

    }*/

    public void setNombre(String nombre){

        this.Nombre = nombre;

    }

    public String getNombre(){

        return this.Nombre;

    }

    public void setMarca(String marca){

        this.Marca = marca;

    }

    public String getMarca() {

        return Marca;

    }

    public void setTipo(String tipo){

        this.Tipo = tipo;

    }

    public String getTipo() {

        return Tipo;

    }

    public void setPorcentajeRecomendado(int porcentaje){

        this.porcentajeRecomendado = porcentaje;

    }

    public int getPorcentajeRecomendado() {

        return porcentajeRecomendado;

    }

    public void setTiempoMinimoMaceracion(int minimo){

        this.tiempoMinimoMaceracion = minimo;

    }

    public int getTiempoMinimoMaceracion() {

        return tiempoMinimoMaceracion;

    }

    public void setTiempoMaximoMaceracion(int maximo){

        this.tiempoMaximoMaceracion = maximo;

    }

    public int getTiempoMaximoMaceracion() {

        return tiempoMaximoMaceracion;

    }

}
