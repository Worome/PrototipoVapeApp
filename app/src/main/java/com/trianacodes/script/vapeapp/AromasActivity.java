package com.trianacodes.script.vapeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class AromasActivity extends AppCompatActivity {

    private Spinner desplegable;
    private SeekBar sbPorcentaje, sbMinMaceracion, sbMaxMaceracion;
    private EditText ePorcentaje, eMinMaceracion, eMaxMaceracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aromas);


        sbPorcentaje = findViewById(R.id.sbPorcentaje);
        ePorcentaje = findViewById(R.id.etPorcentaje);
        //Llamo a la función que rellena de datos el desplegable
        rellenaDesplegable();
        /*Llamo a la función que va a controlar si se cambia el valor del SeekBar y si es así,
        modificar el contenido del EditText correspondiente*/
        controlaSb();
        /*Llamo a la función que va a controlar si el contenido del EditText ha cambiado y si es
        así, cambio el valor del SeekBar.*/
        controlaEdt();

    }

    public void rellenaDesplegable(){

        /*He definido dentro de strings.xml un string-array llamado "tipos", con todos los tipos de
         * aromas. Ahora,, en esta línea creo un adaptador de tipo ArrayAdapter para luego rellenar
         * la lista desplegable (Spinner)*/
        ArrayAdapter tipos = ArrayAdapter.createFromResource(this, R.array.tipos,
                android.R.layout.simple_spinner_dropdown_item);
        // Asigno el desplegable de la interfaz al objeto de tipo Spinner que he creado (desplegable)
        desplegable = findViewById(R.id.spTipo);
        // Establezco el tipo de lista del adaptador
        tipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Le asigno al objeto de tipo Spinner el adaptador que he construido
        desplegable.setAdapter(tipos);

    }

    public void controlaSb(){

        sbPorcentaje.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                ePorcentaje.setText(""+ sbPorcentaje.getProgress());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void controlaEdt(){

        ePorcentaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (ePorcentaje.getText().toString() != null){

                    sbPorcentaje.setProgress(parseInt(ePorcentaje.getText().toString()));

                } else {

                    sbPorcentaje.setProgress(0);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


}
